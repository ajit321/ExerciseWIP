package com.wipro.exercise.base

import com.wipro.exercise.model.bean.ExerciseResponse

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> ExerciseResponse<T>): ExerciseResponse<T> {
        return call.invoke()
    }

}