package com.adammcneilly.pokedex.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PokemonListContent(
    state: PokemonListState,
    modifier: Modifier = Modifier,
) {
    PokemonListGrid(
        pokemonList = state.request.getOrNull().orEmpty(),
        modifier = modifier,
    )
}
