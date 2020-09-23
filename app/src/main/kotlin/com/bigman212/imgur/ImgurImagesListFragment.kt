package com.bigman212.imgur

import android.content.Context
import android.os.Bundle
import android.view.View
import com.bigman212.imgur.di.AppComponent
import com.bigman212.imgur.remote.ImgurApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


class ImgurImagesListFragment : BaseFragment(R.layout.fragment_imgur_images_list) {
    @Inject
    internal lateinit var api: ImgurApi

    companion object {
        @JvmStatic
        fun newInstance(): ImgurImagesListFragment = ImgurImagesListFragment()
    }

    override fun onAttach(context: Context) {
        (appComponent as AppComponent).inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        api.fetchGalleryImages("hot", "top", 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Timber.e(it.string()) },
                { Timber.e(it) }
            )
    }

}
