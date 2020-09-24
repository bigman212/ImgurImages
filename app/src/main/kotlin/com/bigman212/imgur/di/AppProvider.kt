package com.bigman212.imgur.di

import com.bigman212.imgur.common.AppFragmentFactory
import com.bigman212.imgur.data.remote.di.ApiProvider

interface AppProvider : ApiProvider {
    fun appFragmentFactory(): AppFragmentFactory
}
