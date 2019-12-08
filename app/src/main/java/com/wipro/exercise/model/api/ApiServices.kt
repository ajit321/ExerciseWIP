package com.wipro.exercise.model.api

import com.wipro.exercise.model.bean.AboutCanada
import com.wipro.exercise.model.bean.ExerciseResponse
import com.wipro.exercise.model.bean.Row
import retrofit2.http.GET

interface ApiServices {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    suspend fun getHomePageJson(): ExerciseResponse<List<Row>>
}