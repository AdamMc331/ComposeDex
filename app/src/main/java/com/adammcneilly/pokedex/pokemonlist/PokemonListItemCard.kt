package com.adammcneilly.pokedex.pokemonlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.PokemonType
import com.adammcneilly.pokedex.models.PokemonTypePreviewParameterProvider
import com.adammcneilly.pokedex.ui.components.ImageWrapper
import com.adammcneilly.pokedex.ui.theme.DexTheme
import com.adammcneilly.pokedex.ui.theme.PokemonTypeTheme

@Composable
fun PokemonListItemCard(
    pokemon: PokemonDisplayModel,
    modifier: Modifier = Modifier,
) {
    PokemonTypeTheme(
        type = pokemon.types.first(),
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = modifier
                .width(IntrinsicSize.Min),
        ) {
            Box {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(DexTheme.dimensions.componentPadding)
                        .fillMaxWidth(),
                ) {
                    ImageWrapper(
                        image = pokemon.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(DexTheme.dimensions.imageSizeDefault),
                    )

                    Text(
                        text = pokemon.name,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(top = DexTheme.dimensions.componentPadding),
                    )
                }

                IconButton(
                    onClick = {
                        // Handle favorite clicked
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                ) {
                    val icon = if (pokemon.isFavorite) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    }

                    val contentDescription = if (pokemon.isFavorite) {
                        "Remove Favorite"
                    } else {
                        "Favorite"
                    }

                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                    )
                }
            }
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
private fun PokemonListCardPreview(
    @PreviewParameter(PokemonTypePreviewParameterProvider::class) type: PokemonType,
) {
    val pokemon = PokemonDisplayModel(
        id = 1,
        name = "Bulbasaur",
        types = listOf(type),
        image = ImageDisplayModel.Local(R.drawable.bulbasaur),
        isFavorite = false,
    )

    DexTheme {
        PokemonListItemCard(pokemon)
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
private fun FavoritePokemonListCardPreview() {
    val pokemon = PokemonDisplayModel(
        id = 1,
        name = "Bulbasaur",
        types = listOf(PokemonType.GRASS),
        image = ImageDisplayModel.Local(R.drawable.bulbasaur),
        isFavorite = false,
    )

    DexTheme {
        PokemonListItemCard(pokemon)
    }
}
