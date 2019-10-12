package com.kstechsolutions.mvvm.data.network

enum class Status {
    SUCCESS, ERROR, LOADING
}

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        @JvmStatic
        fun <T> success(data: T? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        @JvmStatic
        fun <T> error(msg: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        @JvmStatic
        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

    fun isLoading(): Boolean = status == Status.LOADING
}

fun <T, Y> Resource<T>.replaceData(data: Y?): Resource<Y> {
    return Resource(this.status, data, this.message)
}