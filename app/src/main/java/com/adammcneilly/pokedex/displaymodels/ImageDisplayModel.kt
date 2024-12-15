package com.adammcneilly.pokedex.displaymodels

import androidx.annotation.DrawableRes

sealed interface ImageDisplayModel {
    data class Remote(
        val url: String,
    ) : ImageDisplayModel

    data class Local(
        @DrawableRes
        val resourceId: Int,
    ) : ImageDisplayModel

    data object Placeholder : ImageDisplayModel

    companion object {
        fun remoteOrPlaceholder(
            url: String?,
        ): ImageDisplayModel {
            return url?.let(::Remote) ?: Placeholder
        }
    }
}
