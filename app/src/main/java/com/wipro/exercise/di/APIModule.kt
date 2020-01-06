package com.wipro.exercise.di

import com.squareup.moshi.Moshi
import com.wipro.exercise.commn.Constants
import com.wipro.exercise.model.api.ApiServices
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class APIModule {

    @Singleton
    @Provides
    fun provideRetrofit(): ApiServices {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient())
            .build().create(ApiServices::class.java)
    }


}