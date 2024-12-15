package com.adammcneilly.pokedex.ui.theme

import android.annotation.TargetApi
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp

private val darkColorScheme = darkColorScheme(
    primary = Purple200,
    secondary = Teal200,
)

private val lightColorScheme = lightColorScheme(
    primary = Purple500,
    secondary = Teal200,
)

private val dexDimensions = Dimensions(
    chipPaddingHorizontal = 12.dp,
    chipPaddingVertical = 4.dp,
    componentPadding = 16.dp,
    imageSizeDefault = 48.dp,
    imageSizeLarge = 80.dp,
    itemSpacingCompact = 8.dp,
    itemSpacingDefault = 16.dp,
    listItemSpacing = 16.dp,
    screenPadding = 16.dp,
)

@Composable
@TargetApi(Build.VERSION_CODES.S)
fun DexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    CompositionLocalProvider(
        LocalDimensions provides dexDimensions,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}

object DexTheme {
    val dimensions: Dimensions
        @Composable
        get() = LocalDimensions.current
}
