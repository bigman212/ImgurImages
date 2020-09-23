package com.bigman212.imgur

import android.os.Bundle
import androidx.navigation.findNavController
import com.bigman212.imgur.di.AppComponent

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (appComponent as AppComponent).inject(this)

        val navController = findNavController(R.id.root_nav_host_fragment)
    }
}
