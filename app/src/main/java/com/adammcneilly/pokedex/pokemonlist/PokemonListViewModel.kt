package com.adammcneilly.pokedex.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.data.repositories.PokemonRepository
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(PokemonListState(DataRequest.Loading))
    val state = mutableState.asStateFlow()

    init {
        viewModelScope.launch {
            pokemonRepository
                .observePokemonList()
                .collect { request ->
                    val newRequest = request.mapToDisplayModels()

                    updateRequest(newRequest)
                }
        }
    }

    private fun updateRequest(
        newRequest: DataRequest<List<PokemonDisplayModel>>,
    ) {
        mutableState.update { currentState ->
            currentState.copy(
                request = newRequest,
            )
        }
    }
}

private fun DataRequest<List<Pokemon>>.mapToDisplayModels(): DataRequest<List<PokemonDisplayModel>> =
    this.map { pokemonList ->
        pokemonList.map { pokemon ->
            PokemonDisplayModel(pokemon)
        }
    }
