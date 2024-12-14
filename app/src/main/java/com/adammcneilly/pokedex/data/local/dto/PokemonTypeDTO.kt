package com.adammcneilly.pokedex.data.local.dto

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.pokedex.models.PokemonType

@Entity
data class PokemonTypeDTO(
    @PrimaryKey
    val typeId: String,
) {
    constructor(type: PokemonType) : this(
        typeId = type.name,
    )

    fun toPokemonType(): PokemonType {
        Log.d("ADAMLOG", "PARSING TYPE: $this")
        return PokemonType.valueOf(typeId)
    }
}
