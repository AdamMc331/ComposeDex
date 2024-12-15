package com.adammcneilly.pokedex.di

import com.adammcneilly.pokedex.data.remote.ApolloItemRepository
import com.adammcneilly.pokedex.data.remote.ApolloPokemonRepository
import com.adammcneilly.pokedex.data.repositories.ItemRepository
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
        pokemonRepositoryImpl: ApolloPokemonRepository,
    ): PokemonRepository

    @Binds
    abstract fun bindItemRepository(
        pokemonRepositoryImpl: ApolloItemRepository,
    ): ItemRepository
}
