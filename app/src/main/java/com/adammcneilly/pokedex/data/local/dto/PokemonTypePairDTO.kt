package com.adammcneilly.pokedex.data.local.dto

import androidx.room.Entity

@Entity(primaryKeys = ["pokemonId", "typeId"])
data class PokemonTypePairDTO(
    val pokemonId: Int,
    val typeId: String,
)
