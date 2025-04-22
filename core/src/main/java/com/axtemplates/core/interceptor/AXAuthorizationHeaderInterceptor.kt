package com.axtemplates.core.interceptor

import com.axtemplates.core.config.AxEnvironment
import okhttp3.Interceptor
import okhttp3.Response

class AXAuthorizationHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().newBuilder()
            .addHeader(HEADER_API_APPLICATION_ID, AxEnvironment.appId)
            .addHeader(HEADER_API_KEY, AxEnvironment.apiKey)
            .build()
    )

    private companion object {
        const val HEADER_API_APPLICATION_ID = "X-Parse-Application-Id"
        const val HEADER_API_KEY = "X-Parse-REST-API-Key"
    }
}