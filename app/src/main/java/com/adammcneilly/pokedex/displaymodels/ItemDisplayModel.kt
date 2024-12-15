package com.adammcneilly.pokedex.displaymodels

import com.adammcneilly.pokedex.models.Item

data class ItemDisplayModel(
    val id: String,
    val name: String,
    val image: ImageDisplayModel,
) {
    constructor(item: Item) : this(
        id = item.id,
        name = item.parseName(),
        image = ImageDisplayModel.remoteOrPlaceholder(item.imageUrl),
    )
}

private fun Item.parseName(): String {
    return name.split("-").joinToString(" ") { item ->
        item.replaceFirstChar(Char::uppercaseChar)
    }
}
