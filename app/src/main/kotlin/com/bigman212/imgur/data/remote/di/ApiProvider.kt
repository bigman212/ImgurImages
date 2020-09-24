package com.bigman212.imgur.data.remote.di

import com.bigman212.imgur.data.remote.ImgurApi

interface ApiProvider {
    fun imgurApi(): ImgurApi
}
