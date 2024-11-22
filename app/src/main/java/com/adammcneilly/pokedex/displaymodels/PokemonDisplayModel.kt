package com.adammcneilly.pokedex.displaymodels

import com.adammcneilly.pokedex.models.PokemonType

data class PokemonDisplayModel(
    val id: Int,
    val types: List<PokemonType>,
    val name: String,
    val image: ImageDisplayModel,
)
