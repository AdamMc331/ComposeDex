package com.adammcneilly.pokedex.list

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.PokemonType
import com.adammcneilly.pokedex.ui.components.ImageWrapper
import com.adammcneilly.pokedex.ui.theme.DexTheme
import com.adammcneilly.pokedex.ui.theme.PokemonTypeTheme

@Composable
fun PokemonListCard(
    pokemon: PokemonDisplayModel,
    modifier: Modifier = Modifier,
) {
    PokemonTypeTheme(
        type = pokemon.types.first(),
    ) {
        Card(
            modifier = modifier,
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(DexTheme.dimensions.itemSpacingCompact),
                modifier = Modifier
                    .padding(DexTheme.dimensions.componentPadding),
            ) {
                PokemonNameTypes(pokemon)

                ImageWrapper(
                    image = pokemon.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(DexTheme.dimensions.imageSizeDefault),
                )
            }
        }
    }
}

@Composable
private fun PokemonNameTypes(pokemon: PokemonDisplayModel) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DexTheme.dimensions.itemSpacingDefault),
    ) {
        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.titleSmall,
        )

        PokemonTypes(pokemon)
    }
}

@Composable
private fun PokemonTypes(pokemon: PokemonDisplayModel) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DexTheme.dimensions.itemSpacingCompact),
    ) {
        pokemon.types.forEach { type ->
            PokemonTypeChip(type)
        }
    }
}

@Composable
private fun PokemonTypeChip(type: PokemonType) {
    Text(
        text = type.name,
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.inversePrimary,
                shape = CircleShape,
            )
            .padding(DexTheme.dimensions.chipPadding),
    )
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
private fun PokemonListCardPreview() {
    val pokemon = PokemonDisplayModel(
        id = "1",
        name = "Bulbasaur",
        types = listOf(
            PokemonType.GRASS,
            PokemonType.POISON,
        ),
        image = ImageDisplayModel.Placeholder,
    )

    DexTheme {
        PokemonListCard(pokemon)
    }
}
