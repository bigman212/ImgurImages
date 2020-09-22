package com.bigman212

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity {
    constructor() : super()
    constructor(@LayoutRes layoutId: Int) : super(layoutId)

    protected val appComponent: AppProvider by lazy {
        (applicationContext as App).appComponent
    }
}
