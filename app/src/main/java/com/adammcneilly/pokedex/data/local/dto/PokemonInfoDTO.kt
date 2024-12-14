package com.adammcneilly.pokedex.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.pokedex.models.Pokemon

@Entity
data class PokemonInfoDTO(
    @PrimaryKey
    val pokemonId: Int,
    val name: String,
) {
    constructor(pokemon: Pokemon) : this(
        pokemonId = pokemon.id,
        name = pokemon.name,
    )
}
