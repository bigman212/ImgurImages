package com.bigman212.imgur.remote

import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bigman212.imgur.remote.pojo.StandardListResponse
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
}
