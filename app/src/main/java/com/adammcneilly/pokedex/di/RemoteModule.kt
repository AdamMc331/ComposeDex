package com.adammcneilly.pokedex.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient =
        ApolloClient
            .Builder()
            .serverUrl("https://beta.pokeapi.co/graphql/v1beta")
            .build()
}
