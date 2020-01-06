package com.wipro.exercise

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wipro.exercise.model.bean.ExerciseResponse
import com.wipro.exercise.model.bean.Row
import com.wipro.exercise.model.repository.HomeRepository
import com.wipro.exercise.vm.HomeViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class SampleTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @MockK
    lateinit var repository: HomeRepository
    private lateinit var homeViewModel: HomeViewModel


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        homeViewModel = Mockito.spy(HomeViewModel::class.java)


    }

    @Test
    fun testFetchRepositories_Positive() {
        coEvery { repository.getHomePageJson() } returns ExerciseResponse(
            200, "success", listOf(
                Row("", "a", "name"),
                Row("", "b", "name"),
                Row("", "c", "name")
            ), "Sample code"
        )

        homeViewModel.homePageData.observeForever {}

        //val result =homeViewModel.getHomePageJson()

        assert(homeViewModel.homePageData.value != null)
        // assert(homeViewModel.homePageData.value!! == result.rows)
    }

    @Test
    fun testFetchRepositories_Negative() {
        coEvery { repository.getHomePageJson() } coAnswers { throw Exception("No network") }

        homeViewModel.homePageData.observeForever {}

        homeViewModel.getHomePageJson {
            //toast("error")
        }

        assert(homeViewModel.homePageData.value != null)
        //assert(homeViewModel.homePageData.value!!.isNotEmpty() == Results.ERROR)
    }
}