package com.leveloper.library.utils

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

fun <T> Result<T>.onSuccess(onSuccess: (T) -> Unit): Result<T> {
    if (this is Result.Success) {
        onSuccess(this.data)
    }
    return this
}

fun Result<*>.onError(onError: (Exception) -> Unit): Result<*> {
    if (this is Result.Error) {
        onError(exception)
    }
    return this
}

fun Result<*>.onLoading(onLoading: () -> Unit): Result<*> {
    if (this is Result.Loading) {
        onLoading()
    }
    return this
}

/**
 * `true` if [Result] is of type [Result.Success] & holds non-null [Result.Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null