package com.wipro.exercise.model.api

import com.wipro.exercise.app.ExerciseApp
import com.wipro.exercise.utils.NetWorkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!NetWorkUtils.isNetworkAvailable(ExerciseApp.CONTEXT)) {
            request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }
        val response = chain.proceed(request)
        if (!NetWorkUtils.isNetworkAvailable(ExerciseApp.CONTEXT)) {
            val maxAge = 60 * 60
            response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, max-age=$maxAge")
                .build()
        } else {
            val maxStale = 60 * 60 * 24 * 28 // tolerate 4-weeks stale
            response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .build()
        }
        return response
    }
}