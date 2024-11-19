package com.adammcneilly.pokedex.di

import com.apollographql.apollo.ApolloClient
import dagger.Provides
import javax.inject.Singleton

object RemoteModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient =
        ApolloClient
            .Builder()
            .serverUrl("https://beta.pokeapi.co/graphql/v1beta")
            .build()
}
