package com.bigman212.imgur

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.bigman212.imgur.di.AppProvider

open class BaseActivity : AppCompatActivity {
    constructor() : super()
    constructor(@LayoutRes layoutId: Int) : super(layoutId)

    protected val appComponent: AppProvider by lazy {
        (applicationContext as App).appComponent
    }
}
