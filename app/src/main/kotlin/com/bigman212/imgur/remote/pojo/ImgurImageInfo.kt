package com.bigman212.imgur.remote.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImgurImageInfo(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "datetime")
    val datetime: Int,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "animated")
    val animated: Boolean,
    @field:Json(name = "width")
    val width: Int,
    @field:Json(name = "height")
    val height: Int,
    @field:Json(name = "size")
    val size: Int,
    @field:Json(name = "views")
    val views: Int,
    @field:Json(name = "bandwidth")
    val bandwidth: Long,
    @field:Json(name = "vote")
    val vote: Any?,
    @field:Json(name = "favorite")
    val favorite: Boolean,
    @field:Json(name = "nsfw")
    val nsfw: Any?,
    @field:Json(name = "section")
    val section: Any?,
    @field:Json(name = "account_url")
    val accountUrl: Any?,
    @field:Json(name = "account_id")
    val accountId: Int?,
    @field:Json(name = "is_ad")
    val isAd: Boolean,
    @field:Json(name = "in_most_viral")
    val inMostViral: Boolean,
    @field:Json(name = "tags")
    val tags: List<Any>,
    @field:Json(name = "ad_type")
    val adType: Int,
    @field:Json(name = "ad_url")
    val adUrl: String,
    @field:Json(name = "in_gallery")
    val inGallery: Boolean,
    @field:Json(name = "deletehash")
    val deletehash: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "link")
    val link: String
)
