package com.axtemplates.core.api

import com.axtemplates.core.retrofit.AXRetrofitBuilder
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit

open class AXApiImpl<A : AXApi>(
    private val apiClass: Class<A>,
    private val apiUrl: String,
) : KoinComponent {
    private var retrofit: Retrofit = createRetrofit()

    protected val api: A = retrofit.create(apiClass)

    private fun createRetrofit(token: String? = null): Retrofit {
        return AXRetrofitBuilder().createRetrofit(token, apiUrl)
    }

    protected fun reinitializeApi(token: String? = null): A {
        retrofit = createRetrofit(token)
        return retrofit.create(apiClass)
    }
}