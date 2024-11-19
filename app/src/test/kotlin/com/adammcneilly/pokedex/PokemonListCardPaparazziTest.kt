package com.adammcneilly.pokedex

import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.PokemonType
import org.junit.Test

class PokemonListCardPaparazziTest : BasePaparazziTest() {
    private val testPokemon = PokemonDisplayModel(
        id = "1",
        name = "Bulbasaur",
        types = listOf(PokemonType.GRASS, PokemonType.POISON),
        image = ImageDisplayModel.Placeholder,
    )

    @Test
    fun renderDefault() {
        snapshotScreen {
            PokemonListCard(
                pokemon = testPokemon,
            )
        }
    }
}
