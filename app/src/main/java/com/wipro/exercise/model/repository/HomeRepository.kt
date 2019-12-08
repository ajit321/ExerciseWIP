package com.wipro.exercise.model.repository

import com.wipro.exercise.base.BaseRepository
import com.wipro.exercise.model.api.ExerciseRestClient
import com.wipro.exercise.model.bean.AboutCanada
import com.wipro.exercise.model.bean.ExerciseResponse
import com.wipro.exercise.model.bean.Row

class HomeRepository : BaseRepository()  {

    suspend fun getHomePageJson(): ExerciseResponse<List<Row>> {
        return apiCall { ExerciseRestClient.wServer.getHomePageJson()}
    }


}