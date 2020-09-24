package com.bigman212.imgur.data.remote.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StandardListResponse<LT>(
    @field:Json(name = "data")
    val data: List<LT>,

    @field:Json(name = "success")
    val isSuccessful: Boolean,

    @field:Json(name = "status")
    val httpStatusCode: Int
)
