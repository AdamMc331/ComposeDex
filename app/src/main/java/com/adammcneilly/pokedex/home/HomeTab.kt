package com.adammcneilly.pokedex.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.ui.graphics.vector.ImageVector
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.itemslist.ItemsListScreen
import com.adammcneilly.pokedex.pokemonlist.PokemonListScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class HomeTab<T>(
    val route: T,
) {
    @Serializable
    data object PokemonList : HomeTab<PokemonListScreen>(PokemonListScreen)

    @Serializable
    data object ItemsList : HomeTab<ItemsListScreen>(ItemsListScreen)

    val icon: ImageVector
        get() = when (this) {
            PokemonList -> Icons.Default.CatchingPokemon
            ItemsList -> Icons.Default.Backpack
//            Favorites -> Icons.Default.Favorite
        }

    val label: Int
        @StringRes get() = when (this) {
            PokemonList -> R.string.pokemon
            ItemsList -> R.string.items
//            Favorites -> R.string.favorites
        }
}
