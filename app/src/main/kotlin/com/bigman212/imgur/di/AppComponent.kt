package com.bigman212.imgur.di

import android.app.Application
import com.bigman212.imgur.MainActivity
import com.bigman212.imgur.di.modules.FragmentsModule
import com.bigman212.imgur.gallery.ImgurGalleryFragment
import com.bigman212.imgur.gallery_image.ImgurGalleryImageFragment
import com.bigman212.imgur.remote.di.modules.ApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApiModule::class, FragmentsModule::class]
)
interface AppComponent : AppProvider {

    fun inject(obj: MainActivity)

    fun inject(obj: ImgurGalleryFragment)
    fun inject(obj: ImgurGalleryImageFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    companion object {
        fun init(application: Application): AppComponent {
            return DaggerAppComponent.factory()
                .create(application)
        }
    }
}
