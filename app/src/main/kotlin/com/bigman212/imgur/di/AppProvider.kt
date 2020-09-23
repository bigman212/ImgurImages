package com.bigman212.imgur.di

import com.bigman212.imgur.remote.di.ApiProvider

interface AppProvider : ApiProvider {
    fun appFragmentFactory(): AppFragmentFactory
}
