package com.adammcneilly.pokedex.pokemonlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.serialization.Serializable

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
        modifier = modifier
            .fillMaxSize(),
    )
}

@Serializable
object PokemonListScreen
