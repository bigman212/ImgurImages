package com.bigman212

import android.app.Application
import timber.log.Timber

class App : Application() {
    val appComponent: AppProvider by lazy {
        AppComponent.init(this)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
