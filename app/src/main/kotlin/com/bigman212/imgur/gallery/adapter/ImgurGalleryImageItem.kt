package com.bigman212.imgur.gallery.adapter

import android.view.View
import androidx.core.content.ContextCompat
import com.bigman212.imgur.R
import com.bigman212.imgur.databinding.ItemImgurImageBinding
import com.bigman212.imgur.remote.pojo.ImgurImageInfo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.xwray.groupie.viewbinding.BindableItem
import java.util.*

class ImgurGalleryImageItem(private val itemToBind: ImgurImageInfo) : BindableItem<ItemImgurImageBinding>() {

    override fun getId(): Long {
        return UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE
    }

    override fun bind(binding: ItemImgurImageBinding, position: Int) {
        val d = ContextCompat.getDrawable(binding.root.context, R.drawable.ic_launcher_background)

        binding.textView.text = itemToBind.link
        binding.imgImgurImage.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        Glide.with(binding.root)
            .load(itemToBind.link)
            .diskCacheStrategy(DiskCacheStrategy.ALL) //use this to cache
            .override(itemToBind.width, itemToBind.width)
            .placeholder(d)
            .into(binding.imgImgurImage)
    }

    override fun getLayout(): Int = R.layout.item_imgur_image

    override fun initializeViewBinding(view: View): ItemImgurImageBinding = ItemImgurImageBinding.bind(view)
}
