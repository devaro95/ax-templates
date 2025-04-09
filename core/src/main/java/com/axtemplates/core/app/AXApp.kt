package com.axtemplates.core.app

import android.app.Application
import com.axtemplates.core.di.axPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class AXApp : Application() {

    private val diModules = listOf(axPresentationModule) + addModules()

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(diModules)
        }
    }

    abstract fun addModules(): List<Module>
}