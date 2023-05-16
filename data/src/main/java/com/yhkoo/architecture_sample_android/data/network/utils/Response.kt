package com.yhkoo.architecture_sample_android.data.network.utils

import okhttp3.ResponseBody

sealed class Response<out T> {

    data class Success<out T>(val value: T) : Response<T>()

    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Response<Nothing>()

    object Loading : Response<Nothing>()

}