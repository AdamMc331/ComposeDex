package com.adammcneilly.pokedex.util

object PokedexNumberFormatter {
    fun format(pokedexNumber: Int): String {
        val formattedNumber = pokedexNumber.toString().padStart(3, '0')
        return "#$formattedNumber"
    }
}
