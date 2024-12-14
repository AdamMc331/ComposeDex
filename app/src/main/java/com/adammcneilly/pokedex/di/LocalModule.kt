package com.adammcneilly.pokedex.di

import android.content.Context
import androidx.room.Room
import com.adammcneilly.pokedex.data.local.PokedexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext
        appContext: Context,
    ): PokedexDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = PokedexDatabase::class.java,
            name = "pokedex.db",
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
