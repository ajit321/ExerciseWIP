package com.wipro.exercise.model.api

import com.wipro.exercise.app.App
import com.wipro.exercise.base.BaseRetrofitClient
import com.wipro.exercise.commn.Constants
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

object RestClient : BaseRetrofitClient() {

    val wServer by lazy { getServer(ApiServices::class.java, Constants.BASE_URL) }


    override fun handleConverterFactory(builder: Retrofit.Builder) {
        builder.addConverterFactory(MoshiConverterFactory.create())

    }

    override fun handleBuilder(builder: OkHttpClient.Builder) {
        super.handleBuilder(builder)
        val httpCacheDirectory = File(App.CONTEXT.cacheDir, "responses")
        val cacheSize = 10 * 1024 * 1024L // 10 MiB
        val cache = Cache(httpCacheDirectory, cacheSize)
        builder.cache(cache)
            .addInterceptor(CacheInterceptor())
    }
}