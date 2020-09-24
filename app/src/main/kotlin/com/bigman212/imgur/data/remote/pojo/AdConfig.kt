package com.bigman212.imgur.data.remote.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdConfig(
    @field:Json(name = "safeFlags")
    val safeFlags: List<String>,
    @field:Json(name = "highRiskFlags")
    val highRiskFlags: List<Any>,
    @field:Json(name = "unsafeFlags")
    val unsafeFlags: List<Any>,
    @field:Json(name = "wallUnsafeFlags")
    val wallUnsafeFlags: List<Any>,
    @field:Json(name = "showsAds")
    val showsAds: Boolean
)
