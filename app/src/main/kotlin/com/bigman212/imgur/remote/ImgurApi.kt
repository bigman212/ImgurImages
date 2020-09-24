package com.bigman212.imgur.remote

import com.bigman212.imgur.remote.pojo.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurApi {
    @GET("gallery/{section}/{sort}/{page}")
    fun fetchGalleryImages(
        @Path("section") section: String,
        @Path("sort") sorting: String,
        @Path("page") page: Int,

        @Query("showViral") showViral: Boolean = true,
    ): Single<StandardListResponse<ImgurGallery>>

    @GET("image/{galleryImageHash}")
    fun fetchGalleryImage(@Path("galleryImageHash") imageHash: String)
            : Single<StandardResponse<ImgurImageInfo>>

    @GET("gallery/{galleryHash}/comments/top")
    fun fetchGalleryOrImageComments(@Path("galleryHash") hash: String)
            : Single<StandardListResponse<GalleryComment>>

}
