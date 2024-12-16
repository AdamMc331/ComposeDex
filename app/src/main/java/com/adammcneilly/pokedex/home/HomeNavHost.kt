package com.adammcneilly.pokedex.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adammcneilly.pokedex.itemslist.ItemsListScreen
import com.adammcneilly.pokedex.pokemonlist.PokemonListScreen

@Composable
fun HomeNavHost(
    navController: NavHostController,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = PokemonListScreen,
        modifier = modifier,
    ) {
        composable<PokemonListScreen> {
            PokemonListScreen(
                contentPadding = contentPadding,
            )
        }

        composable<ItemsListScreen> {
            ItemsListScreen(
                contentPadding = contentPadding,
            )
        }
    }
}
