package com.volozhinsky.cathunter.data

import com.volozhinsky.cathunter.data.mappers.CatBreedMapper
import com.volozhinsky.cathunter.data.mappers.CatMapper
import com.volozhinsky.cathunter.data.services.ThecatapiService
import com.volozhinsky.cathunter.domain.models.Cat
import com.volozhinsky.cathunter.domain.models.CatBreed
import com.volozhinsky.cathunter.domain.repository.TheCatApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TheCatApiRepositoryImpl @Inject constructor(
    val catBreedMapper: CatBreedMapper,
    val catService: ThecatapiService,
    val catMapper: CatMapper
) : TheCatApiRepository {


    override suspend fun getBreeds(): List<CatBreed> {
        return withContext(Dispatchers.IO) {
            catService.getCatsBreeds().execute().body()?.map { catBreedMapper(it) }
                ?: throw Exception()
        }
    }

    override suspend fun getRandomCatOfTheBreed(idBreed: String): Cat {
        return catService.getRandomCatOfTheBreed(idBreed).execute().body()?.get(0)
            ?.let { catMapper(it) } ?: throw Exception()
    }
}