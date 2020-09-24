package com.bigman212.imgur.data.remote.interceptors

import com.bigman212.imgur.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor() : Interceptor {
    companion object {
        private const val AUTHORIZATION_HEADER_NAME = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val clientId = BuildConfig.AUTH_CLIENT_ID
        val requestWithAuthHeader = request
            .newBuilder()
            .addHeader(AUTHORIZATION_HEADER_NAME, generateAuthorizationHeaderValue(clientId))
            .build()

        return chain.proceed(requestWithAuthHeader)
    }

    private fun generateAuthorizationHeaderValue(clientId: String): String = "Client-ID $clientId"
}
