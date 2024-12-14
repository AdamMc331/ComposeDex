package com.adammcneilly.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adammcneilly.pokedex.data.local.dto.PokemonDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonInfoDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonTypeDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonTypePairDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface PokedexDao {
    @Query("SELECT * FROM PokemonInfoDTO")
    fun getAllPokemon(): Flow<List<PokemonDTO>>

    @Insert(
        onConflict = OnConflictStrategy.IGNORE,
    )
    fun insertPokemon(
        pokemon: PokemonInfoDTO,
    )

    @Insert(
        onConflict = OnConflictStrategy.IGNORE,
    )
    fun insertTypes(
        types: List<PokemonTypeDTO>,
    )

    @Insert(
        onConflict = OnConflictStrategy.IGNORE,
    )
    fun insertTypePairs(
        typePairs: List<PokemonTypePairDTO>,
    )
}
