package com.bigman212.imgur.gallery.domain

import com.bigman212.imgur.gallery.data.ImgurGalleryRepository
import com.bigman212.imgur.gallery.data.ImgurGallerySection
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bigman212.imgur.remote.pojo.StandardListResponse
import io.reactivex.Single
import javax.inject.Inject

class ImgurGalleryUseCase @Inject constructor(private val imgurGalleryRepository: ImgurGalleryRepository) {

    fun getHotImgurGallery(): Single<StandardListResponse<ImgurGallery>> {
        return imgurGalleryRepository.getGallery(ImgurGallerySection.HOT)
    }

    fun getTopImgurGallery(): Single<StandardListResponse<ImgurGallery>> {
        return imgurGalleryRepository.getGallery(ImgurGallerySection.TOP)
    }
}
