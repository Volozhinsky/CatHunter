package com.volozhinsky.cathunter.data.models

import com.google.gson.annotations.SerializedName

data class CatBreedResponse(
    @SerializedName("url") val id: String? = null,
    @SerializedName("url") val name: String? = null
)
