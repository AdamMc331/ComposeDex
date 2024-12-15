package com.adammcneilly.pokedex.data.remote

import com.adammcneilly.pokedex.ItemListQuery
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.data.repositories.ItemRepository
import com.adammcneilly.pokedex.models.Item
import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class ApolloItemRepository @Inject constructor(
    private val apolloClient: ApolloClient,
) : ItemRepository {
    override fun observeItemsList(
        versionGroupId: Int,
    ): Flow<DataRequest<List<Item>>> {
        val query = ItemListQuery(versionGroupId)

        return apolloClient
            .query(query)
            .toFlow()
            .map { data ->
                val items = data
                    .data
                    ?.pokemon_v2_item_aggregate
                    ?.nodes
                    ?.map(ItemListQuery.Node::toItem)

                if (items != null) {
                    DataRequest.Success(items)
                } else {
                    DataRequest.Error(IllegalStateException("Item list is null"))
                }
            }
            .onStart {
                emit(DataRequest.Loading)
            }
    }
}

private fun ItemListQuery.Node.toItem(): Item {
    return Item(
        id = this.id.toString(),
        name = this.name,
        description = pokemon_v2_itemflavortexts.first().flavor_text,
    )
}
