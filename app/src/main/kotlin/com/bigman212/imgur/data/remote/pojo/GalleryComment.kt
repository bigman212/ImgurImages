package com.bigman212.imgur.data.remote.pojo


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryComment(
    @Json(name = "id")
    val id: Int,
    @Json(name = "image_id")
    val imageId: String,
    @Json(name = "caption")
    val caption: String?,
    @Json(name = "comment")
    val comment: String,
    @Json(name = "author")
    val author: String,
    @Json(name = "author_id")
    val authorId: Int,
    @Json(name = "on_album")
    val onAlbum: Boolean,
    @Json(name = "album_cover")
    val albumCover: Any?,
    @Json(name = "ups")
    val ups: Int,
    @Json(name = "downs")
    val downs: Int,
    @Json(name = "points")
    val points: Int,
    @Json(name = "datetime")
    val datetime: Int,
    @Json(name = "parent_id")
    val parentId: Any?,
    @Json(name = "deleted")
    val deleted: Boolean
)
