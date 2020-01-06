package com.wipro.exercise.di

import com.wipro.exercise.model.repository.HomeRepository
import com.wipro.exercise.ui.fragment.HomeFragment
import com.wipro.exercise.vm.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIModule::class])
interface APIComponent {
    fun inject(retrofitRepository: HomeRepository)
    fun inject(retroViewModel: HomeViewModel)
    fun inject(retroFragment: HomeFragment)
}