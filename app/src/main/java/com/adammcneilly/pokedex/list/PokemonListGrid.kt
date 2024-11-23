package com.adammcneilly.pokedex.list

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel
import com.adammcneilly.pokedex.models.PokemonType
import com.adammcneilly.pokedex.ui.theme.DexTheme

@Composable
fun PokemonListGrid(
    pokemonList: List<PokemonDisplayModel>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(DexTheme.dimensions.screenPadding),
        verticalArrangement = Arrangement.spacedBy(DexTheme.dimensions.componentPadding),
        horizontalArrangement = Arrangement.spacedBy(DexTheme.dimensions.componentPadding),
        modifier = modifier,
    ) {
        items(pokemonList) { pokemon ->
            PokemonListCard(
                pokemon = pokemon,
                modifier = Modifier
                    .fillMaxWidth(),
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
private fun PokemonListGridPreview() {
    val pokemonList = PokemonType.entries.mapIndexed { index, type ->
        val name = "Pokemon $type"

        PokemonDisplayModel(
            id = index,
            name = name,
            types = listOf(type),
            image = ImageDisplayModel.Local(R.drawable.bulbasaur),
        )
    }

    DexTheme {
        PokemonListGrid(pokemonList)
    }
}