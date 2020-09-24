package com.bigman212.imgur.data.remote.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageTag(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "display_name")
    val displayName: String,
    @field:Json(name = "followers")
    val followers: Int,
    @field:Json(name = "total_items")
    val totalItems: Int,
    @field:Json(name = "following")
    val following: Boolean,
    @field:Json(name = "is_whitelisted")
    val isWhitelisted: Boolean,
    @field:Json(name = "background_hash")
    val backgroundHash: String,
    @field:Json(name = "thumbnail_hash")
    val thumbnailHash: Any?,
    @field:Json(name = "accent")
    val accent: String?,
    @field:Json(name = "background_is_animated")
    val backgroundIsAnimated: Boolean,
    @field:Json(name = "thumbnail_is_animated")
    val thumbnailIsAnimated: Boolean,
    @field:Json(name = "is_promoted")
    val isPromoted: Boolean,
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "logo_hash")
    val logoHash: Any?,
    @field:Json(name = "logo_destination_url")
    val logoDestinationUrl: Any?,
    @field:Json(name = "description_annotations")
    val descriptionAnnotations: DescriptionAnnotations
)
