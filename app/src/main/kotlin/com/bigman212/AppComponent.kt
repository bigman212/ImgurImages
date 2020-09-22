package com.bigman212

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = []
)
interface AppComponent : AppProvider {

    fun inject(obj: MainActivity)

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
