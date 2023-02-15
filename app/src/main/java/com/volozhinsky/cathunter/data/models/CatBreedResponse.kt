package com.volozhinsky.cathunter.data.models

import com.google.gson.annotations.SerializedName

data class CatBreedResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null
)
