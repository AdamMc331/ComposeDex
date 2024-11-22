package com.adammcneilly.pokedex.util

object PokedexNumberFormatter {
    private const val POKEDEX_NUMBER_DIGITS = 3

    fun format(pokedexNumber: Int): String {
        val formattedNumber = pokedexNumber.toString().padStart(POKEDEX_NUMBER_DIGITS, '0')
        return "#$formattedNumber"
    }
}
