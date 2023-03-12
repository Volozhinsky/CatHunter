package com.volozhinsky.cathunter.di

import com.volozhinsky.cathunter.data.services.ThecatapiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object DataModule {

    @Provides
    @Singleton
    fun provideCatServicey( ):ThecatapiService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ThecatapiService::class.java)
    }
}