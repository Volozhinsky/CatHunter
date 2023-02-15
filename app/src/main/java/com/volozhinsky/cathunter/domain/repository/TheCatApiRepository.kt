package com.volozhinsky.cathunter.domain.repository

import com.volozhinsky.cathunter.domain.models.Cat
import com.volozhinsky.cathunter.domain.models.CatBreed

interface TheCatApiRepository {

    suspend fun getBreeds(): List<CatBreed>
    suspend fun getRandomCatOfTheBreed(idBreed: String): Cat
}