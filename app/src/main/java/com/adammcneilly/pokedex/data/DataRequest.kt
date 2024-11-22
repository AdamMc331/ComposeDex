package com.adammcneilly.pokedex.data

sealed interface DataRequest<out T> {
    data object Loading : DataRequest<Nothing>

    data class Success<T>(
        val data: T,
    ) : DataRequest<T>

    data class Error(
        val error: Throwable,
    ) : DataRequest<Nothing>

    fun <R> map(
        transform: (T) -> R,
    ): DataRequest<R> =
        when (this) {
            is Loading -> Loading
            is Success -> Success(transform(data))
            is Error -> Error(error)
        }

    fun getOrNull(): T? = (this as? Success)?.data
}
