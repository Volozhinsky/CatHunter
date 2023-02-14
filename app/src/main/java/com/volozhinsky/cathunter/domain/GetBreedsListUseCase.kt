package com.volozhinsky.cathunter.domain

import com.volozhinsky.cathunter.domain.models.CatBreed
import com.volozhinsky.cathunter.domain.repository.TheCatApiRepository
import javax.inject.Inject

class GetBreedsListUseCase @Inject constructor(
    private val repository: TheCatApiRepository
) {

    suspend operator fun invoke(): List<CatBreed> {
        return repository.getBreeds()
    }
}