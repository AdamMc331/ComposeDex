package com.adammcneilly.pokedex.models

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

enum class PokemonType {
    BUG,
    DARK,
    DRAGON,
    ELECTRIC,
    FAIRY,
    FIGHTING,
    FIRE,
    FLYING,
    GHOST,
    GRASS,
    GROUND,
    ICE,
    NORMAL,
    POISON,
    PSYCHIC,
    ROCK,
    SHADOW,
    STEEL,
    STELLAR,
    WATER,
    UNKNOWN,
}

class PokemonTypePreviewParameterProvider : PreviewParameterProvider<PokemonType> {
    override val values: Sequence<PokemonType>
        get() = PokemonType.entries.asSequence()
}
