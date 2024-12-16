package com.adammcneilly.pokedex.itemslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.serialization.Serializable

@Composable
fun ItemsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemsListViewModel = hiltViewModel(),
    contentPadding: PaddingValues = PaddingValues(),
) {
    val state = viewModel.state.collectAsState()

    ItemsListContent(
        state = state.value,
        contentPadding = contentPadding,
        modifier = modifier
            .fillMaxSize(),
    )
}

@Serializable
object ItemsListScreen
