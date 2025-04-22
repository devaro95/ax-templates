package com.axtemplates.core.config

import com.vro.constants.EMPTY_STRING

data class AxConfig(
    val apiKey: String = EMPTY_STRING,
    val appId: String = EMPTY_STRING,
    val baseUrl: String = EMPTY_STRING,
    val enableAuthorizationInterceptor: Boolean = false,
)

fun initializeAx(config: AxConfig) {
    AxEnvironment.init(config)
}