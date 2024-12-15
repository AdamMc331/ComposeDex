package com.adammcneilly.pokedex.itemslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.pokedex.displaymodels.ItemDisplayModel
import com.adammcneilly.pokedex.ui.theme.DexTheme
import com.adammcneilly.pokedex.ui.util.plus

@Composable
fun ItemsListGrid(
    itemList: List<ItemDisplayModel>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = contentPadding + PaddingValues(DexTheme.dimensions.screenPadding),
        verticalArrangement = Arrangement.spacedBy(DexTheme.dimensions.componentPadding),
        horizontalArrangement = Arrangement.spacedBy(DexTheme.dimensions.componentPadding),
        modifier = modifier,
    ) {
        items(itemList) { item ->
            ItemsListCard(
                item = item,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}
