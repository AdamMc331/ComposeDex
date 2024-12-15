package com.adammcneilly.pokedex.itemslist

import com.adammcneilly.pokedex.BasePaparazziTest
import com.adammcneilly.pokedex.R
import com.adammcneilly.pokedex.displaymodels.ImageDisplayModel
import com.adammcneilly.pokedex.displaymodels.ItemDisplayModel
import org.junit.Test

class ItemsListCardPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderDefault() {
        val item = ItemDisplayModel(
            id = "1",
            name = "Master Ball",
            image = ImageDisplayModel.Local(R.drawable.masterball),
            description = "The best BALL with the ultimate\nperformance. It will catch any wild\nPOKéMON without fail.",
        )

        snapshotScreen {
            ItemsListCard(item)
        }
    }
}
