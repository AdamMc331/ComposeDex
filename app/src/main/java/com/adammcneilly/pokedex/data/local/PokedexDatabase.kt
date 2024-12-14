package com.adammcneilly.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adammcneilly.pokedex.data.local.dto.PokemonInfoDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonTypeDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonTypePairDTO

@Database(
    entities = [
        PokemonInfoDTO::class,
        PokemonTypeDTO::class,
        PokemonTypePairDTO::class,
    ],
    version = 1,
)
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao
}
