package com.adammcneilly.pokedex.pokemonlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.ui.components.ErrorScreen
import com.adammcneilly.pokedex.ui.components.LoadingScreen
import com.adammcneilly.pokedex.ui.theme.DexTheme

@Composable
fun PokemonListContent(
    state: PokemonListState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
) {
    when (state.request) {
        is DataRequest.Error -> {
            ErrorScreen(
                message = state.request.error.message.orEmpty(),
                modifier = modifier,
            )
        }

        DataRequest.Loading -> {
            LoadingScreen(
                modifier = modifier,
            )
        }

        is DataRequest.Success<List<PokemonDisplayModel>> -> {
            PokemonListGrid(
                pokemonList = state.request.data,
                contentPadding = contentPadding,
                modifier = modifier,
            )
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun PokemonListContentPreview(
    @PreviewParameter(PokemonListStatePreviewParameterProvider::class) state: PokemonListState,
) {
    DexTheme {
        Surface {
            PokemonListContent(
                state = state,
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}
