package com.example.app.domain

inline fun <T> safeCall(call: () -> T): Result<T> = try {
    Result.Success(call.invoke())
} catch (exception: Exception) {
    Result.Failure(exception)
}
