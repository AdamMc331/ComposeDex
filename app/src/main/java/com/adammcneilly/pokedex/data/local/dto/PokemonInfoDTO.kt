package com.adammcneilly.pokedex.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonInfoDTO(
    @PrimaryKey
    val pokemonId: String,
    val name: String,
)
