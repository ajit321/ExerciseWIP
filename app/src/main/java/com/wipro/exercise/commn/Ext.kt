package com.wipro.exercise.commn

import android.app.Activity
import com.wipro.exercise.model.bean.ExerciseResponse
import com.wipro.exercise.model.bean.Row
import com.wipro.exercise.utils.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import retrofit2.HttpException

suspend fun executeResponse(
    result: ExerciseResponse<List<Row>>,
    successBlock: suspend CoroutineScope.() -> Unit,
    errorBlock: suspend CoroutineScope.() -> Unit
) {
    coroutineScope {
        if (result.errorCode == -1) {
            errorBlock()
        } else {
            successBlock()
        }
    }
}



fun Activity.onNetError(e: Throwable, func: (e: Throwable) -> Unit) {
    if (e is HttpException) {
        toast("network anomaly")
        func(e)
    }
}

