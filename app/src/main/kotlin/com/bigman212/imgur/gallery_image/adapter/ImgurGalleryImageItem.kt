package com.bigman212.imgur.gallery_image.adapter

import android.view.View
import com.bigman212.imgur.R
import com.bigman212.imgur.data.remote.pojo.GalleryComment
import com.bigman212.imgur.databinding.ItemGalleryCommentBinding
import com.xwray.groupie.viewbinding.BindableItem

class ImgurGalleryCommentItem(private val itemToBind: GalleryComment) : BindableItem<ItemGalleryCommentBinding>() {

    override fun getId(): Long = itemToBind.id.toLong()

    override fun bind(binding: ItemGalleryCommentBinding, position: Int) {
        binding.tvGalleryCommentAuthor.text = itemToBind.author
        binding.tvGalleryCommentBody.text = itemToBind.comment
    }

    override fun getLayout(): Int = R.layout.item_gallery_comment

    override fun initializeViewBinding(view: View): ItemGalleryCommentBinding = ItemGalleryCommentBinding.bind(view)
}
