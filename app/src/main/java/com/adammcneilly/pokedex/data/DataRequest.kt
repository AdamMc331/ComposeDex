package com.adammcneilly.pokedex.data

sealed interface DataRequest<out T> {
    data object Loading : DataRequest<Nothing>

    data class Success<T>(
        val data: T,
    ) : DataRequest<T>

    data class Error(
        val error: Throwable,
    ) : DataRequest<Nothing>
}
