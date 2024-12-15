package com.adammcneilly.pokedex.itemslist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.ItemDisplayModel
import com.adammcneilly.pokedex.ui.components.ImageWrapper
import com.adammcneilly.pokedex.ui.theme.DexTheme

@Composable
fun ItemsListCard(
    item: ItemDisplayModel,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(DexTheme.dimensions.componentPadding),
        ) {
            ImageWrapper(
                image = item.image,
                contentDescription = item.name,
                modifier = Modifier
                    .size(48.dp),
            )

            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = item.description,
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
private fun ItemsListCardPreview() {
    val item = ItemDisplayModel(
        id = "1",
        name = "Master Ball",
        image = ImageDisplayModel.Local(R.drawable.masterball),
        description = "The best BALL with the ultimate\nperformance. It will catch any wild\nPOKéMON without fail.",
    )

    DexTheme {
        ItemsListCard(item)
    }
}
