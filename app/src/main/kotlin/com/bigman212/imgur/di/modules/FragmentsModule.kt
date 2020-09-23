package com.bigman212.imgur.di.modules

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bigman212.imgur.di.AppFragmentFactory
import com.bigman212.imgur.gallery.ImgurGalleryFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FragmentsModule {
    @Binds
    fun bindFragmentFactory(factory: AppFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(ImgurGalleryFragment::class)
    fun bindImgurImagesFragment(fragment: ImgurGalleryFragment): Fragment
}
