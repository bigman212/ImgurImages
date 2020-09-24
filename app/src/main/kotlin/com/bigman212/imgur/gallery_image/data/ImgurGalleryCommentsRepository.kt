package com.bigman212.imgur.gallery_image.data

import com.bigman212.imgur.remote.ImgurApi
import com.bigman212.imgur.remote.pojo.GalleryComment
import com.bigman212.imgur.remote.pojo.StandardListResponse
import io.reactivex.Single
import javax.inject.Inject

class ImgurGalleryCommentsRepository @Inject constructor(private val api: ImgurApi) {

    fun getGalleryCommentsByHash(galleryHash: String): Single<StandardListResponse<GalleryComment>> {
        return api.fetchGalleryComments(galleryHash)
    }
}
