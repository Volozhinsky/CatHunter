package com.volozhinsky.cathunter.data.mappers

import com.volozhinsky.cathunter.data.models.CatResponse
import com.volozhinsky.cathunter.domain.models.Cat
import javax.inject.Inject

class CatMapper @Inject constructor(){
    operator fun invoke(response: CatResponse) = with(response) {
        Cat(
            catUrl = catUrl ?: ""
        )
    }
}