package com.adammcneilly.pokedex.data

sealed interface DataRequest<out T> {
    data object Loading : DataRequest<Nothing>

    data class Success<out T>(
        val data: T,
    ) : DataRequest<T>

    data class Error(
        val error: Throwable,
    ) : DataRequest<Nothing>

    fun <R> map(
        transform: (T) -> R,
    ): DataRequest<R> {
        return when (this) {
            is Loading -> Loading
            is Success -> Success(transform(data))
            is Error -> Error(error)
        }
    }

    fun getOrNull(): T? {
        return (this as? Success)?.data
    }
}
