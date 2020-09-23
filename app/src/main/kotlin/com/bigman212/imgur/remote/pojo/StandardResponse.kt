package com.bigman212.imgur.remote.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class StandardResponse<T>(
    @field:Json(name = "data")
    val data: T,

    @field:Json(name = "success")
    val isSuccessful: Boolean,

    @field:Json(name = "status")
    val httpStatusCode: Int
)
