package com.volozhinsky.cathunter.di

import com.volozhinsky.cathunter.data.services.ThecatapiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideCatServicey( ):ThecatapiService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ThecatapiService::class.java)
    }
}