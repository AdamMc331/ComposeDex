package com.adammcneilly.pokedex.models

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<PokemonType>,
)
