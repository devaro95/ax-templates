package com.sampleapp

import com.axtemplates.core.app.AXApp
import com.sampleapp.di.cometPresentationModule
import org.koin.core.module.Module

class SampleApp : AXApp() {
    override fun addModules(): List<Module> = listOf(cometPresentationModule)
}