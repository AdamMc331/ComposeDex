package com.adammcneilly.pokedex.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloseFullscreen
import androidx.compose.material.icons.filled.OpenInFull
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.xr.compose.platform.LocalSession
import androidx.xr.compose.platform.LocalSpatialCapabilities
import com.adammcneilly.pokedex.nav.PokedexNavHost

@Composable
fun HomeNavigationContainer(
    modifier: Modifier = Modifier,
) {
    val tabs = remember {
        listOf(
            HomeTab.PokemonList,
            HomeTab.ItemsList,
        )
    }

    val navController = rememberNavController()

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination

    val selectedTab = tabs.find { tab ->
        (currentDestination?.route == tab.route::class.qualifiedName)
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            tabs.forEach { tab ->
                navigationItem(tab, selectedTab, navController)
            }
        },
        modifier = modifier,
    ) {
        Scaffold { scaffoldPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(scaffoldPadding),
            ) {
                PokedexNavHost(
                    navController = navController,
                    contentPadding = scaffoldPadding,
                    modifier = Modifier
                        .fillMaxSize(),
                )

                SpatialModeSwitchFab(
                    modifier = Modifier
                        .align(Alignment.BottomEnd),
                )
            }
        }
    }
}

@Composable
private fun SpatialModeSwitchFab(
    modifier: Modifier = Modifier,
) {
    val xrSession = LocalSession.current ?: return

    val hasSpatialUi = LocalSpatialCapabilities.current.isSpatialUiEnabled

    FloatingActionButton(
        onClick = {
            if (hasSpatialUi) {
                xrSession.requestHomeSpaceMode()
            } else {
                xrSession.requestFullSpaceMode()
            }
        },
        modifier = modifier
            .padding(32.dp),
    ) {
        Icon(
            imageVector = if (hasSpatialUi) {
                Icons.Default.CloseFullscreen
            } else {
                Icons.Default.OpenInFull
            },
            contentDescription = if (hasSpatialUi) {
                "Exit Full Space Mode"
            } else {
                "Enter Full Space Mode"
            },
        )
    }
}

private fun NavigationSuiteScope.navigationItem(
    tab: HomeTab<out Any>,
    selectedTab: HomeTab<out Any>?,
    navController: NavHostController,
) {
    item(
        icon = {
            Icon(
                imageVector = tab.icon,
                contentDescription = stringResource(tab.label),
            )
        },
        label = {
            Text(
                text = stringResource(tab.label),
            )
        },
        selected = (tab == selectedTab),
        onClick = {
            navController.navigate(tab.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().route.orEmpty()) {
                    saveState = true
                }

                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true

                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        },
    )
}
