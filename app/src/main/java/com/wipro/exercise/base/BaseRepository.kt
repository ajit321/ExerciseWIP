package com.wipro.exercise.base

import com.wipro.exercise.model.bean.ExerciseResponse
import com.wipro.exercise.model.bean.Results
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> ExerciseResponse<T>): ExerciseResponse<T> {
        return call.invoke()
    }

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Results<T>,
        errorMessage: String
    ): Results<T> {
        return try {
            call()
        } catch (e: Exception) {
            Results.Error(IOException(errorMessage, e))
        }
    }
}