package com.bigman212.imgur.remote.di.module

import com.bigman212.imgur.remote.ImgurApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
object ApiModule {
    @Provides
    @Singleton
    fun provideImgurApi(retrofit: Retrofit): ImgurApi = retrofit.create(ImgurApi::class.java)
}
