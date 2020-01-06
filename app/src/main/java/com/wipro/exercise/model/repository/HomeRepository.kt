package com.wipro.exercise.model.repository

import com.wipro.exercise.base.BaseRepository
import com.wipro.exercise.di.DaggerAPIComponent
import com.wipro.exercise.model.api.ApiServices
import com.wipro.exercise.model.api.RestClient
import com.wipro.exercise.model.bean.ExerciseResponse
import com.wipro.exercise.model.bean.Row
import javax.inject.Inject

class HomeRepository : BaseRepository() {

    @Inject
    lateinit var apiServices: ApiServices

    init {
        DaggerAPIComponent.builder().build().inject(this)
    }

    suspend fun getHomePageJson(): ExerciseResponse<List<Row>> {
        return apiCall {
            apiServices.getHomePageJson()
        }
    }


}