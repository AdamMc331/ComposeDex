package com.adammcneilly.pokedex.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.data.repositories.PokemonRepository
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    @Named("local")
    private val pokemonRepository: PokemonRepository,
    @Named("remote")
    private val remotePokemonRepository: PokemonRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(PokemonListState(DataRequest.Loading))
    val state = mutableState.asStateFlow()

    init {
        syncData()

        viewModelScope.launch {
            pokemonRepository
                .observePokemonList()
                .collect { request ->
                    val newRequest = request.mapToDisplayModels()

                    updateRequest(newRequest)
                }
        }
    }

    /**
     * TODO: Move this into a special workflow
     */
    private fun syncData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                remotePokemonRepository
                    .observePokemonList()
                    .collect { request ->
                        if (request is DataRequest.Success) {
                            val pokemonList = request.data
                            pokemonRepository.insertPokemonList(pokemonList)
                        }
                    }
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
