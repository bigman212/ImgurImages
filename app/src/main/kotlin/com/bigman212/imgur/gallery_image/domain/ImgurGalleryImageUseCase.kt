package com.bigman212.imgur.gallery_image.domain

import com.bigman212.imgur.data.ImgurGalleryCommentsRepository
import com.bigman212.imgur.data.ImgurGalleryRepository
import com.bigman212.imgur.data.remote.pojo.GalleryComment
import com.bigman212.imgur.data.remote.pojo.ImgurGallery
import com.bigman212.imgur.data.remote.pojo.StandardListResponse
import com.bigman212.imgur.data.remote.pojo.StandardResponse
import io.reactivex.Single
import javax.inject.Inject

class ImgurGalleryImageUseCase @Inject constructor(
    private val imgurGalleryRepository: ImgurGalleryRepository,
    private val imgurGalleryCommentsRepository: ImgurGalleryCommentsRepository
) {

    fun fetchGalleryByHash(galleryHash: String): Single<ImgurGallery> {
        return imgurGalleryRepository.getGalleryByHash(galleryHash)
            .map(StandardResponse<ImgurGallery>::data)
    }

    fun fetchGalleryCommentByGalleryHash(galleryHash: String): Single<List<GalleryComment>> {
        return imgurGalleryCommentsRepository.getGalleryCommentsByHash(galleryHash)
            .map(StandardListResponse<GalleryComment>::data)
    }
}
