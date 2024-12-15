package com.adammcneilly.pokedex.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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
            HomeNavHost(
                navController = navController,
                contentPadding = scaffoldPadding,
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
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
