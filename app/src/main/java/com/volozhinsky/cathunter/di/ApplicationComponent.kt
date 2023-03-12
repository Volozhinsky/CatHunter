package com.volozhinsky.cathunter.di

import android.content.Context
import com.volozhinsky.cathunter.ui.random_cat.RandomCatFragment
import com.volozhinsky.cathunter.ui.select_breed.SelectBreedFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class,
        DataModule::class,
        DataModuleRep::class]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(fragment: SelectBreedFragment)

    fun inject(fragment: RandomCatFragment)
}