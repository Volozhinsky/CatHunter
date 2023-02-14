package com.volozhinsky.cathunter.ui.mappers

import com.volozhinsky.cathunter.domain.models.Cat
import com.volozhinsky.cathunter.ui.models.CatUI
import javax.inject.Inject

class CatUIMapper @Inject constructor(){

    operator fun invoke(response: Cat) = with(response) {
        CatUI(
            catUrl = catUrl
        )
    }
}