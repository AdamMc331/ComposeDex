package com.adammcneilly.pokedex.data.repositories

import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun observePokemonList(): Flow<DataRequest<List<Pokemon>>>
}
