@file:Suppress("MagicNumber")

package com.adammcneilly.pokedex.theme

import androidx.compose.ui.graphics.Color
import com.adammcneilly.pokedex.models.PokemonType

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Teal200 = Color(0xFF03DAC5)

object PokemonColors {
    private val Bug = Color(0xFFA6B91A)
    private val Dark = Color(0xFF705746)
    private val Dragon = Color(0xFF6F35FC)
    private val Electric = Color(0xFFF7D02C)
    private val Fairy = Color(0xFFD685AD)
    private val Fighting = Color(0xFFC22E28)
    private val Fire = Color(0xFFEE8130)
    private val Flying = Color(0xFFA98FF3)
    private val Ghost = Color(0xFF735797)
    private val Grass = Color(0xFF7AC74C)
    private val Ground = Color(0xFFE2BF65)
    private val Ice = Color(0xFF96D9D6)
    private val Normal = Color(0xFFA8A77A)
    private val Poison = Color(0xFFA33EA1)
    private val Psychic = Color(0xFFF95587)
    private val Rock = Color(0xFFB6A136)
    private val Steel = Color(0xFFB7B7CE)
    private val Water = Color(0xFF6390F0)

    @Suppress("CyclomaticComplexMethod")
    fun fromType(type: PokemonType): Color =
        when (type) {
            PokemonType.BUG -> Bug
            PokemonType.DARK -> Dark
            PokemonType.DRAGON -> Dragon
            PokemonType.ELECTRIC -> Electric
            PokemonType.FAIRY -> Fairy
            PokemonType.FIGHTING -> Fighting
            PokemonType.FIRE -> Fire
            PokemonType.FLYING -> Flying
            PokemonType.GHOST -> Ghost
            PokemonType.GRASS -> Grass
            PokemonType.GROUND -> Ground
            PokemonType.ICE -> Ice
            PokemonType.NORMAL -> Normal
            PokemonType.POISON -> Poison
            PokemonType.PSYCHIC -> Psychic
            PokemonType.ROCK -> Rock
            PokemonType.SHADOW -> Normal
            PokemonType.STEEL -> Steel
            PokemonType.STELLAR -> Normal
            PokemonType.WATER -> Water
            PokemonType.UNKNOWN -> Normal
        }
}
