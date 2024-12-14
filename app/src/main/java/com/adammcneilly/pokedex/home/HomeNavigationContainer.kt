package com.adammcneilly.pokedex.home

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun HomeNavigationContainer(
    selectedTab: HomeTab,
    onTabChanged: (HomeTab) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            HomeTab.entries.forEach { tab ->
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
                        onTabChanged.invoke(tab)
                    },
                )
            }
        },
        modifier = modifier,
        content = content,
    )
}
