package com.java90.simplemoviesapp.domain.utils

sealed class Resource<out T>(val data: T? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Failure<T>(message: String?, data: T? = null) : Resource<T>(data)
}

