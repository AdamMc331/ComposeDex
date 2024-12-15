package com.adammcneilly.pokedex.itemslist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ItemsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemsListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()

    ItemsListContent(
        state = state.value,
        modifier = modifier,
    )
}
