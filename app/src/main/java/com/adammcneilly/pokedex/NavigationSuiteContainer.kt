package com.adammcneilly.pokedex

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.pokedex.navigation.HomeTab

@Composable
fun NavigationSuiteContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    var currentDestination by remember {
        mutableStateOf(HomeTab.HOME)
    }

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
                    selected = (tab == currentDestination),
                    onClick = {
                        currentDestination = tab
                    },
                )
            }
        },
        modifier = modifier,
        content = content,
    )
}
