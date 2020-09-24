package com.bigman212.imgur.gallery.data

import com.bigman212.imgur.remote.ImgurApi
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bigman212.imgur.remote.pojo.StandardListResponse
import com.bigman212.imgur.remote.pojo.StandardResponse
import io.reactivex.Single
import javax.inject.Inject

class ImgurGalleryRepository @Inject constructor(private val api: ImgurApi) {
    fun getGallery(
        section: ImgurGallerySection = ImgurGallerySection.HOT,
        sorting: ImgurGallerySorting = ImgurGallerySorting.VIRAL
    ): Single<StandardListResponse<ImgurGallery>> {
        val sectionPath = section.name.toLowerCase()
        val sortingPath = sorting.name.toLowerCase()
        return api.fetchGalleryImages(sectionPath, sortingPath, 1)
    }

    fun getGalleryByHash(galleryHash: String): Single<StandardResponse<ImgurGallery>> {
        return api.fetchGalleryByHash(galleryHash)
    }
}
