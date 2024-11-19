package com.adammcneilly.pokedex.models

data class Pokemon(
    val id: String,
    val name: String,
    val types: List<PokemonType>,
)
