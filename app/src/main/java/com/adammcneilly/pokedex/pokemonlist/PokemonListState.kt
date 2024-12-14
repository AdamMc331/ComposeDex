package com.adammcneilly.pokedex.pokemonlist

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.PokemonType

data class PokemonListState(
    val request: DataRequest<List<PokemonDisplayModel>>,
)

class PokemonListStatePreviewParameterProvider : PreviewParameterProvider<PokemonListState> {
    private val loading = PokemonListState(
        request = DataRequest.Loading,
    )

    private val success = PokemonListState(
        request = DataRequest.Success(
            List(SAMPLE_LIST_SIZE) {
                PokemonDisplayModel(
                    id = 1,
                    name = "Bulbasaur",
                    types = listOf(PokemonType.GRASS, PokemonType.POISON),
                    image = ImageDisplayModel.Local(R.drawable.bulbasaur),
                    isFavorite = false,
                )
            },
        ),
    )

    private val error = PokemonListState(
        request = DataRequest.Error(
            error = Throwable("Something went wrong"),
        ),
    )

    override val values: Sequence<PokemonListState>
        get() = sequenceOf(loading, success, error)

    companion object {
        private const val SAMPLE_LIST_SIZE = 10
    }
}
