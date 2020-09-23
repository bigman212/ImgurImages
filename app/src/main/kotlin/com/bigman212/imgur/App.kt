package com.bigman212.imgur

import android.app.Application
import com.bigman212.imgur.di.AppComponent
import com.bigman212.imgur.di.AppProvider
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
