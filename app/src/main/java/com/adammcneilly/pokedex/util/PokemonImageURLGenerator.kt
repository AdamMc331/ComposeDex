package com.adammcneilly.pokedex.util

object PokemonImageURLGenerator {
    fun generate(
        pokemonId: Int,
    ): String {
        val pokedexNumber = PokedexNumberFormatter.format(pokemonId)

        return "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$pokedexNumber.png"
    }
}
