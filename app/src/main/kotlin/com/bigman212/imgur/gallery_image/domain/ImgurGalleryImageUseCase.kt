package com.bigman212.imgur.gallery_image.domain

import com.bigman212.imgur.gallery.data.ImgurGalleryRepository
import javax.inject.Inject

class ImgurGalleryImageUseCase @Inject constructor(
    private val imgurGalleryRepository: ImgurGalleryRepository
) {

}
