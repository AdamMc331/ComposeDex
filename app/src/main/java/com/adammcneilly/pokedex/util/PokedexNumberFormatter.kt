package com.adammcneilly.pokedex.util

object PokedexNumberFormatter {
    private const val POKEDEX_NUMBER_DIGITS = 3

    fun format(
        pokemonId: Int,
    ): String {
        require(pokemonId > 0) {
            "PokemonID must be a positive integer."
        }

        return pokemonId.toString().padStart(POKEDEX_NUMBER_DIGITS, '0')
    }
}
