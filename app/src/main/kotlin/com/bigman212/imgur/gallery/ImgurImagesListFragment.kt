package com.bigman212.imgur.gallery

import android.content.Context
import android.os.Bundle
import android.view.View
import com.bigman212.imgur.BaseFragment
import com.bigman212.imgur.R
import com.bigman212.imgur.common.viewBinding
import com.bigman212.imgur.common.viewModelWithProvider
import com.bigman212.imgur.databinding.FragmentImgurImagesListBinding
import com.bigman212.imgur.di.AppComponent
import com.bigman212.imgur.remote.ImgurApi
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bigman212.imgur.remote.pojo.StandardListResponse
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider


class ImgurImagesListFragment @Inject constructor(
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

//        binding.rvImgurImages.layoutManager = LinearLayoutManager(requireContext())
        binding.rvImgurImages.adapter = adapter

        val subscribe = api.fetchGalleryImages("hot", "top", 1)
            .map(StandardListResponse<ImgurGallery>::data)
            .flatMapObservable { Observable.fromIterable(it) }
            .filter { it.images != null }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    this@ImgurImagesListFragment.render(it)
                }
            ) { Timber.e(it) }
    }


    private fun render(gallery: List<ImgurGallery>) {
        val res = gallery.map { it.images!! }
            .reduce { acc, list -> acc.toMutableList() + list }
            .map(::ImgurImageListItem)

        adapter.add(section)
        section.update(res)
    }
}
