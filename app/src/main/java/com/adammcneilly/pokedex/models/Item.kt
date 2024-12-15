package com.adammcneilly.pokedex.models

data class Item(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val description: String,
)
