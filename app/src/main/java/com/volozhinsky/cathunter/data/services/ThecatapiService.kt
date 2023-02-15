package com.volozhinsky.cathunter.data.services

import com.volozhinsky.cathunter.data.models.CatBreedResponse
import com.volozhinsky.cathunter.data.models.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ThecatapiService {
    @GET("breeds")
    fun getCatsBreeds(): Call<List<CatBreedResponse>>

    @GET("images/search")
    fun getRandomCatOfTheBreed(@Query("breed_ids") id: String):Call<List<CatResponse>>
}