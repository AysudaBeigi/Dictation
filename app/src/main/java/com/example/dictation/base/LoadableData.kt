package com.example.dictation.base

sealed class LoadableData<out T> {

    abstract val data: T?
}

data class Loaded<T>(override val data: T) : LoadableData<T>()
data class Failed<T>(val throwable: Throwable, val title: String? = null) : LoadableData<T>() {
    override val data: T?
        get() = null
}

object Loading : LoadableData<Nothing>() {
    override val data: Nothing?
        get() = null
}

object NotLoaded : LoadableData<Nothing>() {
    override val data: Nothing?
        get() = null
}
