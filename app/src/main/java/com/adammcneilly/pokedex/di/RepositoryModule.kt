package com.adammcneilly.pokedex.di

import com.adammcneilly.pokedex.data.remote.ApolloPokeAPIService
import com.adammcneilly.pokedex.data.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * This module is responsible for defining the creation of any repository dependencies used in the
 * application.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: ApolloPokeAPIService,
    ): PokemonRepository
}
