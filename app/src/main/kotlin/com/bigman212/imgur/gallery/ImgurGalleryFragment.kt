package com.bigman212.imgur.gallery

import android.content.Context
import android.os.Bundle
import android.view.View
import com.bigman212.imgur.BaseFragment
import com.bigman212.imgur.R
import com.bigman212.imgur.common.observe
import com.bigman212.imgur.common.viewBinding
import com.bigman212.imgur.common.viewModelWithProvider
import com.bigman212.imgur.databinding.FragmentImgurImagesListBinding
import com.bigman212.imgur.di.AppComponent
import com.bigman212.imgur.gallery.adapter.ImgurGalleryItem
import com.bigman212.imgur.remote.ImgurApi
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import javax.inject.Inject
import javax.inject.Provider


class ImgurGalleryFragment @Inject constructor(
    private val viewModelProvider: Provider<ImgurGalleryViewModel>
) : BaseFragment(R.layout.fragment_imgur_images_list) {
    @Inject
    internal lateinit var api: ImgurApi

    private val binding by viewBinding<FragmentImgurImagesListBinding>()
    private val viewModel by viewModelWithProvider { viewModelProvider.get() }

    private val section = Section()
    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onAttach(context: Context) {
        (appComponent as AppComponent).inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvImgurImages.adapter = adapter
        adapter.add(section)

        observe(viewModel.viewState, ::renderState)

        viewModel.fetchImgurGalleryWithImages()
    }

    private fun renderState(state: ImgurGalleryViewModel.State) {
        when (state) {
            ImgurGalleryViewModel.State.Loading -> {

            }
            is ImgurGalleryViewModel.State.Content -> renderContent(state.data)
            is ImgurGalleryViewModel.State.Error -> showMessage(state.error.message ?: state.error.toString())
        }
    }


    private fun renderContent(content: List<ImgurGallery>) {
        section.update(content.map { ImgurGalleryItem(it, ::onImgurGalleryClicked) })
    }

    private fun onImgurGalleryClicked(gallery: ImgurGallery) {
        val directions = ImgurGalleryFragmentDirections.toImgurGalleryImageFragment(gallery.id)
        navigateTo(directions)
    }
}
