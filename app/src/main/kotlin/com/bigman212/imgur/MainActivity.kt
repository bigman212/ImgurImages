package com.bigman212.imgur

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.navigation.findNavController
import com.bigman212.imgur.common.base.BaseActivity
import com.bigman212.imgur.di.AppComponent
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    @Inject
    internal lateinit var fFactory: FragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (appComponent as AppComponent).inject(this)
        supportFragmentManager.fragmentFactory = fFactory
        super.onCreate(savedInstanceState)


        val navController = findNavController(R.id.root_nav_host_fragment)

    }

    override fun onSupportNavigateUp() = findNavController(R.id.root_nav_host_fragment).navigateUp()
}
