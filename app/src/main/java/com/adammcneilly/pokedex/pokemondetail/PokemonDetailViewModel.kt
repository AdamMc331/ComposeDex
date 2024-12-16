package com.adammcneilly.pokedex.pokemondetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    init {
        val id = savedStateHandle.get<Int>("pokemonId")
        Log.d("ADAMLOG", "ID: $id")
        Log.d("ADAMLOG", "Keys: ${savedStateHandle.keys()}")
    }
}
