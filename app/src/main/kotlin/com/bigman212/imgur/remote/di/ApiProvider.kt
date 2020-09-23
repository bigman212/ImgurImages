package com.bigman212.imgur.remote.di

import com.bigman212.imgur.remote.ImgurApi

interface ApiProvider {
    fun imgurApi(): ImgurApi
}
