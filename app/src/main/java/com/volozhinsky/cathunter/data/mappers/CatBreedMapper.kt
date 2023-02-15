package com.volozhinsky.cathunter.data.mappers

import com.volozhinsky.cathunter.data.models.CatBreedResponse
import com.volozhinsky.cathunter.domain.models.CatBreed
import javax.inject.Inject

class CatBreedMapper @Inject constructor() {
    operator fun invoke(response: CatBreedResponse) = with(response) {
        CatBreed(
            name = name ?: "",
            id = id ?: ""
        )
    }
}