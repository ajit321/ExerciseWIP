package com.wipro.exercise.vm

import androidx.lifecycle.MutableLiveData
import com.wipro.exercise.base.BaseViewModel
import com.wipro.exercise.commn.executeResponse
import com.wipro.exercise.model.bean.AboutCanada
import com.wipro.exercise.model.bean.Row
import com.wipro.exercise.model.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {
    private val homeRepository by lazy { HomeRepository() }
    val homePageData : MutableLiveData<List<Row>> = MutableLiveData()
val appTitle: MutableLiveData<String> = MutableLiveData()


    fun getHomePageJson( errorBlock: suspend CoroutineScope.()-> Unit) {
        launch {
            val result = withContext(Dispatchers.IO) {
                homeRepository.getHomePageJson()
            }
            appTitle.value = result.title
            executeResponse(result, {homePageData.value = result.rows}, errorBlock)
        }
    }
}