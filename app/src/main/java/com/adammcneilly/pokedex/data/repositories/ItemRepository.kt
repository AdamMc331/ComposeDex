package com.adammcneilly.pokedex.data.repositories

import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.models.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun observeItemsList(
        versionGroupId: Int,
    ): Flow<DataRequest<List<Item>>>
}
