package com.axtemplates.core.template

import com.vro.compose.navigator.VROTemplateNavigator

open class SampleTemplateNavigator<D : SampleTemplateDestinations>() : VROTemplateNavigator<D>() {

    override fun navigate(destination: D) {
        when (destination) {
            SampleTemplateDestinations.FollowDestination -> onProfileClick()
        }
    }

    open fun onProfileClick() = Unit
}