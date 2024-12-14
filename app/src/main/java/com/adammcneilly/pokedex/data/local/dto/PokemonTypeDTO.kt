package com.adammcneilly.pokedex.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonTypeDTO(
    @PrimaryKey
    val typeId: String,
)
