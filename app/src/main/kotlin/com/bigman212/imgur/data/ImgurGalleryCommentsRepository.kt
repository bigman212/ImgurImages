package com.bigman212.imgur.data

import com.bigman212.imgur.data.remote.ImgurApi
import com.bigman212.imgur.data.remote.pojo.GalleryComment
import com.bigman212.imgur.data.remote.pojo.StandardListResponse
import io.reactivex.Single
import javax.inject.Inject

class ImgurGalleryCommentsRepository @Inject constructor(private val api: ImgurApi) {

    fun getGalleryCommentsByHash(galleryHash: String): Single<StandardListResponse<GalleryComment>> {
        return api.fetchGalleryComments(galleryHash)
    }
}
