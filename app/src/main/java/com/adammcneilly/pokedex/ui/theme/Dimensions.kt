package com.adammcneilly.pokedex.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val chipPaddingVertical: Dp,
    val chipPaddingHorizontal: Dp,
    val componentPadding: Dp,
    val imageSizeDefault: Dp,
    val itemSpacingCompact: Dp,
    val itemSpacingDefault: Dp,
    val listItemSpacing: Dp,
    val screenPadding: Dp,
) {
    val chipPadding = PaddingValues(
        horizontal = chipPaddingHorizontal,
        vertical = chipPaddingVertical,
    )
}

val LocalDimensions = staticCompositionLocalOf {
    Dimensions(
        chipPaddingHorizontal = 0.dp,
        chipPaddingVertical = 0.dp,
        componentPadding = 0.dp,
        imageSizeDefault = 0.dp,
        itemSpacingCompact = 0.dp,
        itemSpacingDefault = 0.dp,
        listItemSpacing = 0.dp,
        screenPadding = 0.dp,
    )
}
