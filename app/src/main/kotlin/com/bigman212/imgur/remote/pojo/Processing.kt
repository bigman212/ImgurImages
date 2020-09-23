package com.bigman212.imgur.remote.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Processing(
    @Json(name = "status")
    val status: String
)
