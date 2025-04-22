package com.axtemplates.core.retrofit

import com.axtemplates.core.config.AxEnvironment
import com.axtemplates.core.interceptor.AXAuthorizationHeaderInterceptor
import com.vro.retrofit.VRORetrofitBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class AXRetrofitBuilder() : VRORetrofitBuilder() {
    override fun addInterceptors(token: String?) = mutableListOf<Interceptor>().apply {
        if (AxEnvironment.enableAuthorizationInterceptor) add(AXAuthorizationHeaderInterceptor())
    }

    override fun loggingInterceptorLevel() = HttpLoggingInterceptor.Level.BODY
}