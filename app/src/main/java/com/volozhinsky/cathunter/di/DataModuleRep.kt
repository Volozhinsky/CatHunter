package com.volozhinsky.cathunter.di

import com.volozhinsky.cathunter.data.TheCatApiRepositoryImpl
import com.volozhinsky.cathunter.domain.repository.TheCatApiRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModuleRep {

    @Binds
    @Singleton
    abstract fun getCatRepository(impl: TheCatApiRepositoryImpl): TheCatApiRepository
}
