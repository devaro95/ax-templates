package com.sampleapp.ui.profileone.presentation

import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateDestinations
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateNavigator
import com.sampleapp.ui.home.SampleHomeScreen

open class ProfileOneSubTemplateNavigator : ProfileOneTemplateNavigator<ProfileOneTemplateDestinations>() {

    override fun onProfileClick() {
        navigateToScreen(SampleHomeScreen())
    }

    sealed class ProfileOneSubTemplateDestinations : ProfileOneTemplateDestinations()
}