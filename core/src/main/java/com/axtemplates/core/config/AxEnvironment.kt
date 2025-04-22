package com.axtemplates.core.config

object AxEnvironment {
    private lateinit var config: AxConfig

    fun init(config: AxConfig) {
        this.config = config
    }

    fun getConfig(): AxConfig {
        if (!::config.isInitialized) {
            throw IllegalStateException("AxEnvironment not initialized")
        }
        return config
    }

    val apiKey: String
        get() = getConfig().apiKey

    val appId: String
        get() = getConfig().appId

    val enableAuthorizationInterceptor: Boolean
        get() = getConfig().enableAuthorizationInterceptor

    val baseUrl: String
        get() = getConfig().baseUrl
}