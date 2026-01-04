package com.rojo.weattherToday.data.remote

import retrofit2.Response

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

// Extension function for easy error handling
suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Result<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful && response.body() != null) {
            Result.Success(response.body()!!)
        } else {
            Result.Error(Exception("Error: ${response.code()} ${response.message()}"))
        }
    } catch (e: Exception) {
        Result.Error(e)
    }
}