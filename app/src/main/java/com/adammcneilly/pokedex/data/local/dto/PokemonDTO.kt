package com.adammcneilly.pokedex.data.local.dto

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonDTO(
    @Embedded
    val info: PokemonInfoDTO,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "typeId",
    )
    val types: List<PokemonTypeDTO>,
)
