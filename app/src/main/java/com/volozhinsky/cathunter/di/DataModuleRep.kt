package com.volozhinsky.cathunter.di

import com.volozhinsky.cathunter.data.TheCatApiRepositoryImpl
import com.volozhinsky.cathunter.domain.repository.TheCatApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleRep {

    @Binds
    abstract fun getCatRepository(impl: TheCatApiRepositoryImpl): TheCatApiRepository
}
