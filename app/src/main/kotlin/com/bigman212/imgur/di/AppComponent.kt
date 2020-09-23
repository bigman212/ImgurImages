package com.bigman212.imgur.di

import android.app.Application
import com.bigman212.imgur.MainActivity
import com.bigman212.imgur.di.modules.FragmentsModule
import com.bigman212.imgur.gallery.ImgurImagesListFragment
import com.bigman212.imgur.remote.di.module.ApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApiModule::class, FragmentsModule::class]
)
interface AppComponent : AppProvider {

    fun inject(obj: MainActivity)

    fun inject(obj: ImgurImagesListFragment)

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
