package com.adammcneilly.pokedex.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adammcneilly.pokedex.itemslist.ItemsListScreen
import com.adammcneilly.pokedex.pokemondetail.PokemonDetailScreen
import com.adammcneilly.pokedex.pokemonlist.PokemonListScreen

@Composable
fun PokedexNavHost(
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
            val localContext = LocalContext.current

            PokemonListScreen(
                contentPadding = contentPadding,
                onPokemonClicked = { pokemonId ->
                    navController.navigate(PokemonDetailScreen(pokemonId))
                },
            )
        }

        composable<ItemsListScreen> {
            ItemsListScreen(
                contentPadding = contentPadding,
            )
        }

        composable<PokemonDetailScreen> {
            PokemonDetailScreen(
                contentPadding = contentPadding,
            )
        }
    }
}
