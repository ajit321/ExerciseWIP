package com.wipro.exercise.model.api

import com.wipro.exercise.app.ExerciseApp
import com.wipro.exercise.base.BaseRetrofitClient
import com.wipro.exercise.commn.Constants
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

object ExerciseRestClient : BaseRetrofitClient() {

    val wServer by lazy { getServer(ApiServices::class.java, Constants.BASE_URL) }


    override fun handleConverterFactory(builder: Retrofit.Builder) {
        //builder.addConverterFactory(GsonConverterFactory.create())
        builder.addConverterFactory(MoshiConverterFactory.create())
        /*val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        builder.addConverterFactory(MoshiConverterFactory.create(moshi))*/
    }



    override fun handleBuilder(builder: OkHttpClient.Builder) {
        super.handleBuilder(builder)
        val httpCacheDirectory = File(ExerciseApp.CONTEXT.cacheDir, "responses")
        val cacheSize = 10 * 1024 * 1024L // 10 MiB
        val cache = Cache(httpCacheDirectory, cacheSize)
        builder.cache(cache)
            .addInterceptor(CacheInterceptor())
    }
}