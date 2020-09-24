package com.bigman212.imgur.gallery.domain

import com.bigman212.imgur.data.ImgurGalleryRepository
import com.bigman212.imgur.data.ImgurGallerySection
import com.bigman212.imgur.data.remote.pojo.ImgurGallery
import com.bigman212.imgur.data.remote.pojo.StandardListResponse
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
