package com.wipro.exercise

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.wipro.exercise.model.api.ApiServices
import com.wipro.exercise.model.api.ExerciseRestClient
import com.wipro.exercise.model.bean.ExerciseResponse
import com.wipro.exercise.model.bean.Results
import com.wipro.exercise.model.bean.Row
import com.wipro.exercise.model.repository.HomeRepository
import com.wipro.exercise.utils.toast
import com.wipro.exercise.vm.HomeViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(JUnit4::class)
class SampleTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var apiServices: ApiServices
@MockK
lateinit var repository: HomeRepository
    lateinit var homeViewModel : HomeViewModel
    lateinit var homePageData :MutableLiveData<List<Row>>


    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        homeViewModel = Mockito.spy(HomeViewModel::class.java)


    }
    @Test
    fun testFetchRepositories_Positive() {
        coEvery { repository.getHomePageJson() } returns  ExerciseResponse(200,"sucess",  listOf(
            Row("","a", "name"),
            Row("","b", "name"),
            Row("","c", "name")
        ),"Sample code" )

        homeViewModel.homePageData.observeForever {}

        //val result =homeViewModel.getHomePageJson()

        assert(homeViewModel.homePageData.value != null)
       // assert(homeViewModel.homePageData.value!! == result.rows)
    }

    @Test
    fun testFetchRepositories_Negative() {
        coEvery { repository.getHomePageJson() } coAnswers { throw Exception("No network") }

        homeViewModel.homePageData.observeForever {}

        homeViewModel.getHomePageJson{
            //toast("error")
        }

        assert(homeViewModel.homePageData.value != null)
        //assert(homeViewModel.homePageData.value!!.isNotEmpty() == Results.ERROR)
    }
}