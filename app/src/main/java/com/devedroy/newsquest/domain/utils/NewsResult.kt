package com.devedroy.newsquest.domain.utils


sealed interface NewsResult<out D, out E : NewsError> {
    data class Success<out D>(val data: D) : NewsResult<D, Nothing>
    data class Error<out E : NewsError>(val error: E) : NewsResult<Nothing, E>
}


inline fun <T, E : NewsError, R> NewsResult<T, E>.map(map: (T) -> R): NewsResult<R, E> =
    when (this) {
        is NewsResult.Error -> NewsResult.Error(error)
        is NewsResult.Success -> NewsResult.Success(map(data))
    }

fun <T, E : NewsError> NewsResult<T, E>.asEmptyDataResult(): EmptyDataResult<E> = map { }

typealias EmptyDataResult<E> = NewsResult<Unit, E>


