package com.sampleapp.ui.subtemplate

import com.axtemplates.core.template.SampleTemplateDestinations
import com.axtemplates.core.template.SampleTemplateNavigator
import com.sampleapp.ui.home.SampleHomeScreen

open class SampleSubTemplateNavigator : SampleTemplateNavigator<SampleTemplateDestinations>() {

    override fun onProfileClick() {
        navigateToScreen(SampleHomeScreen())
    }

    sealed class SampleSubTemplateDestinations : SampleTemplateDestinations()
}