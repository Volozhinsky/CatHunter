package com.volozhinsky.cathunter.di

import androidx.lifecycle.ViewModel
import com.volozhinsky.cathunter.ui.random_cat.RandomCatViewModel
import com.volozhinsky.cathunter.ui.select_breed.SelectBreedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SelectBreedViewModel::class)
    fun bindSelectBreedViewModel(viewModel: SelectBreedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RandomCatViewModel::class)
    fun bindRandomCatViewModel(viewModel: RandomCatViewModel): ViewModel
}