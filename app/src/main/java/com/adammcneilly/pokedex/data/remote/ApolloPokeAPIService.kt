package com.adammcneilly.pokedex.data.remote

import com.adammcneilly.pokedex.PokemonSummaryListQuery
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.data.repositories.PokemonRepository
import com.adammcneilly.pokedex.models.Pokemon
import com.adammcneilly.pokedex.models.PokemonType
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class ApolloPokeAPIService @Inject constructor(
    private val apolloClient: ApolloClient,
) : PokemonRepository {
    override fun observePokemonList(): Flow<DataRequest<List<Pokemon>>> {
        @Suppress("MagicNumber")
        val query = PokemonSummaryListQuery(
            limit = Optional.present(151),
        )

        return apolloClient
            .query(query)
            .toFlow()
            .map { data ->
                val pokemonList = data
                    .data
                    ?.pokemon_v2_pokemon
                    ?.map(PokemonSummaryListQuery.Pokemon_v2_pokemon::toPokemon)

                if (pokemonList != null) {
                    DataRequest.Success(pokemonList)
                } else {
                    DataRequest.Error(IllegalStateException("Pokemon list is null"))
                }
            }.onStart {
                emit(DataRequest.Loading)
            }
    }
}

private fun PokemonSummaryListQuery.Pokemon_v2_pokemon.toPokemon(): Pokemon =
    Pokemon(
        id = this.id.toString(),
        name = name,
        types = pokemon_v2_pokemontypes.map { gqlType ->
            val typeName = gqlType.pokemon_v2_type?.name.orEmpty()
            PokemonType.valueOf(typeName.uppercase())
        },
    )
