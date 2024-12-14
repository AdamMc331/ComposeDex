package com.adammcneilly.pokedex.pokemonlist

import com.adammcneilly.pokedex.BasePaparazziTest
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.PokemonType
import com.google.testing.junit.testparameterinjector.TestParameter
import org.junit.Test

class PokemonListCardPaparazziTest : BasePaparazziTest() {
    private val testPokemon = PokemonDisplayModel(
        id = 1,
        name = "Bulbasaur",
        types = listOf(PokemonType.GRASS, PokemonType.POISON),
        image = ImageDisplayModel.Local(R.drawable.bulbasaur),
        isFavorite = false,
    )

    @Test
    fun renderTypes(
        @TestParameter type: PokemonType,
    ) {
        val pokemon = testPokemon.copy(
            name = type.name,
            types = listOf(type),
        )

        snapshotScreen {
            PokemonListItemCard(
                pokemon = pokemon,
            )
        }
    }

    @Test
    fun renderFavorite() {
        val pokemon = testPokemon.copy(
            isFavorite = true,
        )

        snapshotScreen {
            PokemonListItemCard(
                pokemon = pokemon,
            )
        }
    }
}
