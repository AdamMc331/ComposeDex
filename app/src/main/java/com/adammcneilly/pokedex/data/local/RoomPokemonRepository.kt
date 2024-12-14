package com.adammcneilly.pokedex.data.local

import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.data.local.dto.PokemonDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonInfoDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonTypeDTO
import com.adammcneilly.pokedex.data.local.dto.PokemonTypePairDTO
import com.adammcneilly.pokedex.data.repositories.PokemonRepository
import com.adammcneilly.pokedex.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomPokemonRepository @Inject constructor(
    private val database: PokedexDatabase,
) : PokemonRepository {
    override fun observePokemonList(): Flow<DataRequest<List<Pokemon>>> {
        return database.pokedexDao().getAllPokemon().map { value ->
            val pokemonList = value.map(PokemonDTO::toPokemon)
            DataRequest.Success(pokemonList)
        }
    }

    override suspend fun insertPokemonList(
        pokemonList: List<Pokemon>,
    ) {
        val dao = database.pokedexDao()

        pokemonList.forEach { pokemon ->
            val mappedTypes = pokemon.types.map(::PokemonTypeDTO)
            dao.insertTypes(mappedTypes)

            val mappedTypePairs = mappedTypes.map { type ->
                PokemonTypePairDTO(pokemon.id, type.typeId)
            }
            dao.insertTypePairs(mappedTypePairs)

            dao.insertPokemon(PokemonInfoDTO(pokemon))
        }
    }
}
