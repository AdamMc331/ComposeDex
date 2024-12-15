package com.adammcneilly.pokedex.itemslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.data.repositories.ItemRepository
import com.adammcneilly.pokedex.displaymodels.ItemDisplayModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(ItemsListState(DataRequest.Loading))
    val state = mutableState.asStateFlow()

    init {
        viewModelScope.launch {
            itemRepository
                .observeItemsList(
                    versionGroupId = 7,
                )
                .collect { itemRequest ->
                    val mappedRequest = itemRequest.map { items ->
                        items.map(::ItemDisplayModel)
                    }

                    mutableState.update { currentState ->
                        currentState.copy(
                            request = mappedRequest,
                        )
                    }
                }
        }
    }
}
