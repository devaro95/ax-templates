package com.sampleapp

import com.axtemplates.core.app.AXApp
import com.axtemplates.core.config.AxConfig
import com.axtemplates.core.config.initializeAx
import com.axtemplates.core.di.axPresentationModule
import com.sampleapp.di.cometPresentationModule
import com.vro.constants.EMPTY_STRING
import org.koin.core.module.Module

class SampleApp : AXApp() {
    override fun addModules(): List<Module> = listOf(axPresentationModule, cometPresentationModule)

    override fun onCreate() {
        super.onCreate()
        initializeAx(
            AxConfig(
                apiKey = EMPTY_STRING,
                /** To add ur api key for authorization interceptor header **/
                appId = EMPTY_STRING,
                /** To add ur application id for authorization interceptor header **/
                baseUrl = EMPTY_STRING,
                /** To add ur api baseUrl **/
                enableAuthorizationInterceptor = true
                /** To enable authorization interceptor header **/
            )
        )
    }
}