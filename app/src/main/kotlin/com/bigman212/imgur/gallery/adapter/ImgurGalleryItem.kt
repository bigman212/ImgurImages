package com.bigman212.imgur.gallery.adapter

import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.view.isVisible
import com.bigman212.imgur.R
import com.bigman212.imgur.databinding.ItemImgurImageBinding
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.xwray.groupie.viewbinding.BindableItem
import java.util.*

class ImgurGalleryItem(
    private val itemToBind: ImgurGallery, private val onImageClicked: (ImgurGallery) -> Unit
) : BindableItem<ItemImgurImageBinding>() {

    companion object {
        private const val MAX_IMAGE_WIDTH = 600
        private const val MAX_IMAGE_HEIGHT = 800
    }

    override fun getId(): Long {
        return UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE
    }

    override fun bind(binding: ItemImgurImageBinding, position: Int) {
        binding.root.setOnClickListener { onImageClicked.invoke(itemToBind) }

        binding.tvGalleryTitle.text = itemToBind.title
        binding.imgGalleryImage.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        binding.pbImageLoading.isVisible = true

        val imageToShow = itemToBind.images!!.first()
        val imageRenderWidth = if (imageToShow.width >= MAX_IMAGE_WIDTH) MAX_IMAGE_WIDTH else imageToShow.width
        val imageRenderHeight = if (imageToShow.height >= MAX_IMAGE_HEIGHT) MAX_IMAGE_HEIGHT else imageToShow.height

        Glide.with(binding.root)
            .load(imageToShow.link)
            .override(imageRenderWidth, imageRenderHeight)
            .addListener(getImageLoadingListener(binding))
            .into(binding.imgGalleryImage)
    }

    override fun getLayout(): Int = R.layout.item_imgur_image

    override fun initializeViewBinding(view: View): ItemImgurImageBinding = ItemImgurImageBinding.bind(view)

    private fun getImageLoadingListener(binding: ItemImgurImageBinding): RequestListener<Drawable> {
        return object : RequestListener<Drawable> {
            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                binding.pbImageLoading.isVisible = false
                return false
            }

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                binding.pbImageLoading.isVisible = true
                return false
            }
        }
    }
}
