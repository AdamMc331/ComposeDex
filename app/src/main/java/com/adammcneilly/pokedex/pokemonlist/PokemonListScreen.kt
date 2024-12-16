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
    contentPadding: PaddingValues,
    onPokemonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()

    PokemonListContent(
        state = state.value,
        contentPadding = contentPadding,
        onPokemonClicked = onPokemonClicked,
        modifier = modifier
            .fillMaxSize(),
    )
}

@Serializable
object PokemonListScreen
