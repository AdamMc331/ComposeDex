package com.adammcneilly.pokedex.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
    contentPadding: PaddingValues = PaddingValues(),
) {
    val state = viewModel.state.collectAsState()

    PokemonListContent(
        state = state.value,
        contentPadding = contentPadding,
        modifier = modifier,
    )
}
