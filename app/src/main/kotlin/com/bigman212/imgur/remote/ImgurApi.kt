package com.bigman212.imgur.remote

import com.bigman212.imgur.remote.pojo.GalleryComment
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bigman212.imgur.remote.pojo.StandardListResponse
import com.bigman212.imgur.remote.pojo.StandardResponse
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

    @GET("gallery/{galleryHash}")
    fun fetchGalleryByHash(@Path("galleryHash") galleryHash: String)
            : Single<StandardResponse<ImgurGallery>>

    @GET("gallery/{galleryHash}/comments/top")
    fun fetchGalleryComments(@Path("galleryHash") hash: String)
            : Single<StandardListResponse<GalleryComment>>

}
