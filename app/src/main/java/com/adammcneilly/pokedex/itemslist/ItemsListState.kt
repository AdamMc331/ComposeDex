package com.adammcneilly.pokedex.itemslist

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.ItemDisplayModel

data class ItemsListState(
    val request: DataRequest<List<ItemDisplayModel>>,
)

class ItemsListStatePreviewParameterProvider : PreviewParameterProvider<ItemsListState> {
    private val loading = ItemsListState(
        request = DataRequest.Loading,
    )

    private val success = ItemsListState(
        request = DataRequest.Success(
            List(SAMPLE_LIST_SIZE) {
                ItemDisplayModel(
                    id = "1",
                    name = "Master Ball",
                    image = ImageDisplayModel.Local(R.drawable.masterball),
                    description = "A ball used to catch Pokémon.",
                )
            },
        ),
    )

    private val error = ItemsListState(
        request = DataRequest.Error(
            error = Throwable("Something went wrong"),
        ),
    )

    override val values: Sequence<ItemsListState>
        get() = sequenceOf(loading, success, error)

    companion object {
        private const val SAMPLE_LIST_SIZE = 10
    }
}
