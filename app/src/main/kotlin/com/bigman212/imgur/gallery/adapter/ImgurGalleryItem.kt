package com.bigman212.imgur.gallery.adapter

import android.view.View
import androidx.core.content.ContextCompat
import com.bigman212.imgur.R
import com.bigman212.imgur.databinding.ItemImgurImageBinding
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bumptech.glide.Glide
import com.xwray.groupie.viewbinding.BindableItem
import java.util.*

class ImgurGalleryItem(
    private val itemToBind: ImgurGallery, private val onImageClicked: (ImgurGallery) -> Unit
) : BindableItem<ItemImgurImageBinding>() {

    override fun getId(): Long {
        return UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE
    }

    override fun bind(binding: ItemImgurImageBinding, position: Int) {
        val d = ContextCompat.getDrawable(binding.root.context, R.drawable.ic_launcher_background)

        binding.root.setOnClickListener { onImageClicked.invoke(itemToBind) }

        binding.textView.text = itemToBind.link
        binding.imgImgurImage.setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        val imageToShow = itemToBind.images!!.first()
        Glide.with(binding.root)
            .load(imageToShow.link)
            .override(imageToShow.width, imageToShow.height)
            .placeholder(d)
            .into(binding.imgImgurImage)
    }

    override fun getLayout(): Int = R.layout.item_imgur_image

    override fun initializeViewBinding(view: View): ItemImgurImageBinding = ItemImgurImageBinding.bind(view)
}
