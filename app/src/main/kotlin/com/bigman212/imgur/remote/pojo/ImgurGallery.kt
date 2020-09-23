package com.bigman212.imgur.remote.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImgurGallery(
//    @field:Json(name = "id")
//    val id: String,
//    @field:Json(name = "title")
//    val title: String,
//    @field:Json(name = "description")
//    val description: Any?,
//    @field:Json(name = "datetime")
//    val datetime: Int,
//    @field:Json(name = "cover")
//    val cover: String?,
//    @field:Json(name = "cover_width")
//    val coverWidth: Int?,
//    @field:Json(name = "cover_height")
//    val coverHeight: Int?,
//    @field:Json(name = "account_url")
//    val accountUrl: String,
//    @field:Json(name = "account_id")
//    val accountId: Int,
//    @field:Json(name = "privacy")
//    val privacy: String?,
//    @field:Json(name = "layout")
//    val layout: String?,
//    @field:Json(name = "views")
//    val views: Int,
//    @field:Json(name = "link")
//    val link: String,
//    @field:Json(name = "ups")
//    val ups: Int,
//    @field:Json(name = "downs")
//    val downs: Int,
//    @field:Json(name = "points")
//    val points: Int,
//    @field:Json(name = "score")
//    val score: Int,
//    @field:Json(name = "is_album")
//    val isAlbum: Boolean,
//    @field:Json(name = "vote")
//    val vote: Any?,
//    @field:Json(name = "favorite")
//    val favorite: Boolean,
//    @field:Json(name = "nsfw")
//    val nsfw: Boolean,
//    @field:Json(name = "section")
//    val section: String,
//    @field:Json(name = "comment_count")
//    val commentCount: Int,
//    @field:Json(name = "favorite_count")
//    val favoriteCount: Int,
//    @field:Json(name = "topic")
//    val topic: String,
//    @field:Json(name = "topic_id")
//    val topicId: Int,
//    @field:Json(name = "images_count")
//    val imagesCount: Int?,
//    @field:Json(name = "in_gallery")
//    val inGallery: Boolean,
//    @field:Json(name = "is_ad")
//    val isAd: Boolean,
//    @field:Json(name = "tags")
//    val tags: List<ImageTag>,
//    @field:Json(name = "ad_type")
//    val adType: Int,
//    @field:Json(name = "ad_url")
//    val adUrl: String,
//    @field:Json(name = "in_most_viral")
//    val inMostViral: Boolean,
//    @field:Json(name = "include_album_ads")
//    val includeAlbumAds: Boolean?,
    @field:Json(name = "images")
    val images: List<ImageInfo>?
//    @field:Json(name = "ad_config")
//    val adConfig: AdConfig
)

