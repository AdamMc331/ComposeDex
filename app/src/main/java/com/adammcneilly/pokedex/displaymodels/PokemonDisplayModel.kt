package com.adammcneilly.pokedex.displaymodels

import com.adammcneilly.pokedex.models.Pokemon
import com.adammcneilly.pokedex.models.PokemonType
import com.adammcneilly.pokedex.util.PokemonImageURLGenerator

data class PokemonDisplayModel(
    val id: Int,
    val types: List<PokemonType>,
    val name: String,
    val image: ImageDisplayModel,
    val isFavorite: Boolean,
) {
    constructor(pokemon: Pokemon) : this(
        id = pokemon.id,
        types = pokemon.types,
        name = pokemon.name.replaceFirstChar { char ->
            char.uppercase()
        },
        image = ImageDisplayModel.Remote(
            PokemonImageURLGenerator.generate(pokemon.id),
        ),
        isFavorite = pokemon.isFavorite,
    )
}
