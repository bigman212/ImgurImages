package com.bigman212.imgur.gallery_image

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.bigman212.imgur.R
import com.bigman212.imgur.common.base.BaseFragment
import com.bigman212.imgur.common.observe
import com.bigman212.imgur.common.viewBinding
import com.bigman212.imgur.common.viewModelWithProvider
import com.bigman212.imgur.data.remote.pojo.GalleryComment
import com.bigman212.imgur.data.remote.pojo.ImgurGallery
import com.bigman212.imgur.databinding.FragmentGalleryDetailedImageBinding
import com.bigman212.imgur.di.AppComponent
import com.bigman212.imgur.gallery_image.adapter.ImgurGalleryCommentItem
import com.bumptech.glide.Glide
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import javax.inject.Inject
import javax.inject.Provider


class ImgurGalleryImageFragment @Inject constructor(
    private val viewModelProvider: Provider<ImgurGalleryImageViewModel>
) : BaseFragment(R.layout.fragment_gallery_detailed_image) {

    private val binding by viewBinding<FragmentGalleryDetailedImageBinding>()
    private val viewModel by viewModelWithProvider { viewModelProvider.get() }

    private val args: ImgurGalleryImageFragmentArgs by navArgs()

    private val section = Section()
    private val adapter = GroupAdapter<GroupieViewHolder>().apply {
        add(section)
    }

    override fun onAttach(context: Context) {
        (appComponent as AppComponent).inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        NavigationUI.setupWithNavController(binding.toolbarGalleryImage, findNavController())
        binding.toolbarGalleryImage.title = ""

        binding.rvGalleryDetailedImageComments.adapter = adapter

        val hash = args.clickedGalleryHash
        observe(viewModel.viewState, ::renderState)

        viewModel.fetchGalleryImage(hash)
    }

    private fun renderState(state: ImgurGalleryImageViewModel.State) {
        binding.pbImageLoading.isVisible = state is ImgurGalleryImageViewModel.State.Loading
        when (state) {
            is ImgurGalleryImageViewModel.State.Content -> renderContent(state.galleryData, state.commentData)
            is ImgurGalleryImageViewModel.State.Error -> showMessage(state.error.message ?: state.error.toString())
        }
    }

    private fun renderContent(gallery: ImgurGallery, comments: List<GalleryComment>) {
        binding.tvGalleryImageTitle.text = gallery.title

        val imageToShow = gallery.images!!.first()
        Glide.with(binding.root)
            .load(imageToShow.link)
            .override(imageToShow.width, imageToShow.height)
            .into(binding.imgGalleryDetailedImage)

        binding.tvGalleryImageDetailedUpvotes.text =
            getString(R.string.gallery_detailed_image_upvotes_value, gallery.ups)
        binding.tvGalleryDetailedImageDownvotes.text =
            getString(R.string.gallery_detailed_image_downvotes_value, gallery.downs)

        section.update(comments.map(::ImgurGalleryCommentItem))
    }

}
