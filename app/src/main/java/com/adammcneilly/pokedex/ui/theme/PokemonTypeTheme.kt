package com.adammcneilly.pokedex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.adammcneilly.pokedex.models.PokemonType
import com.materialkolor.rememberDynamicColorScheme

@Composable
fun PokemonTypeTheme(
    type: PokemonType,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = rememberDynamicColorScheme(
        seedColor = PokemonColors.fromType(type),
        isDark = useDarkTheme,
        isAmoled = false,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}
