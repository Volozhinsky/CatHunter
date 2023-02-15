package com.volozhinsky.cathunter.data.models

import com.google.gson.annotations.SerializedName

data class CatResponse(@SerializedName("url") val catUrl: String = "")
