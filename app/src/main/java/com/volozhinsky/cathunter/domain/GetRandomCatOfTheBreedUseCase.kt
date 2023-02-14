package com.volozhinsky.cathunter.domain

import com.volozhinsky.cathunter.domain.models.Cat
import com.volozhinsky.cathunter.domain.models.CatBreed
import com.volozhinsky.cathunter.domain.repository.TheCatApiRepository
import javax.inject.Inject

class GetRandomCatOfTheBreedUseCase @Inject constructor(
    private val repository: TheCatApiRepository
) {

    suspend operator fun invoke(idBreed: String): Cat {
        return repository.getRandomCatOfTheBreed(idBreed)
    }
}