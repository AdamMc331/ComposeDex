package com.adammcneilly.pokedex.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.adammcneilly.pokedex.R

enum class HomeTab(
    @StringRes val label: Int,
    val icon: ImageVector,
) {
    HOME(
        label = R.string.home,
        icon = Icons.Default.Home,
    ),
    FAVORITES(
        label = R.string.favorites,
        icon = Icons.Default.Favorite,
    ),
    SHOPPING(
        label = R.string.shopping,
        icon = Icons.Default.ShoppingCart,
    ),
    PROFILE(
        label = R.string.profile,
        icon = Icons.Default.AccountBox,
    ),
}
