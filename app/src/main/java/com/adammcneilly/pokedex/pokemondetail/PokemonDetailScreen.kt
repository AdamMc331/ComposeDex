package com.adammcneilly.pokedex.pokemondetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.serialization.Serializable

@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    Text(
        text = "Pokemon Detail Stub",
        modifier = modifier,
    )
}

@Serializable
data class PokemonDetailScreen(
    val pokemonId: Int,
)
