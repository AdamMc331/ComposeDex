package com.adammcneilly.pokedex.util

object ItemImageURLGenerator {
    fun generate(
        itemName: String,
    ): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/$itemName.png"
    }
}
