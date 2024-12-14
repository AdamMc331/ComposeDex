package com.adammcneilly.pokedex.data.local.dto

import android.util.Log
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.adammcneilly.pokedex.models.Pokemon

data class PokemonDTO(
    @Embedded
    val info: PokemonInfoDTO,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "typeId",
        associateBy = Junction(PokemonTypePairDTO::class),
    )
    val types: List<PokemonTypeDTO>,
) {
    fun toPokemon(): Pokemon {
        Log.d("ADAMLOG", "PARSING POKEMON: $this")

        return Pokemon(
            id = info.pokemonId,
            name = info.name,
            types = types.map(PokemonTypeDTO::toPokemonType),
        )
    }
}
