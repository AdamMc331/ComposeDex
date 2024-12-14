package com.adammcneilly.pokedex.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import com.adammcneilly.pokedex.R

enum class HomeTab(
    @StringRes val label: Int,
    val icon: ImageVector,
) {
    Pokemon(
        label = R.string.pokemon,
        icon = Icons.Default.CatchingPokemon,
    ),
    Items(
        label = R.string.items,
        icon = Icons.Default.Backpack,
    ),
    Favorites(
        label = R.string.favorites,
        icon = Icons.Default.Favorite,
    ),
}
