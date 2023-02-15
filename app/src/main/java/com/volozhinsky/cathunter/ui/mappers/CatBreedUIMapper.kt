package com.volozhinsky.cathunter.ui.mappers

import com.volozhinsky.cathunter.domain.models.CatBreed
import com.volozhinsky.cathunter.ui.models.CatBreedUI
import javax.inject.Inject

class CatBreedUIMapper @Inject constructor() {

    operator fun invoke(response: CatBreed) = with(response) {
        CatBreedUI(
            name = name,
            id = id
        )
    }
}