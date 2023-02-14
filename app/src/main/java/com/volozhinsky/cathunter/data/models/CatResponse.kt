package com.volozhinsky.cathunter.data.models

import com.google.gson.annotations.SerializedName

data class CatResponse(@SerializedName("catUrl") val catUrl: String = "")
