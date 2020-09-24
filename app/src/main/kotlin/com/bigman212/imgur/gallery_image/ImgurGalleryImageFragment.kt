package com.bigman212.imgur.gallery_image

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bigman212.imgur.BaseFragment
import com.bigman212.imgur.R
import com.bigman212.imgur.common.observe
import com.bigman212.imgur.common.viewBinding
import com.bigman212.imgur.common.viewModelWithProvider
import com.bigman212.imgur.databinding.FragmentGalleryDetailedImageBinding
import com.bigman212.imgur.di.AppComponent
import com.bigman212.imgur.gallery_image.adapter.ImgurGalleryCommentItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider


class ImgurGalleryImageFragment @Inject constructor(
    private val viewModelProvider: Provider<ImgurGalleryImageViewModel>
) : BaseFragment(R.layout.fragment_gallery_detailed_image) {

    private val binding by viewBinding<FragmentGalleryDetailedImageBinding>()
    private val viewModel by viewModelWithProvider { viewModelProvider.get() }

    private val args: ImgurGalleryImageFragmentArgs by navArgs()

    private val section = Section()
    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onAttach(context: Context) {
        (appComponent as AppComponent).inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvGalleryDetailedImageComments.adapter = adapter

        adapter.add(section)

        val hash = args.clickedGalleryHash
        observe(viewModel.viewState, ::renderState)

        viewModel.fetchGalleryImage(hash)
    }

    private fun renderState(state: ImgurGalleryImageViewModel.State) {
        when (state) {
            is ImgurGalleryImageViewModel.State.Content -> {
                section.update(state.data.map(::ImgurGalleryCommentItem))
            }
            ImgurGalleryImageViewModel.State.Loading -> {

            }
            is ImgurGalleryImageViewModel.State.Error -> {
                Timber.e(state.error)
            }
        }
    }

}
