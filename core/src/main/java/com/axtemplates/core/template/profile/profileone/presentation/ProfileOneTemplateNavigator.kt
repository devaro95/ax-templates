package com.axtemplates.core.template.profile.profileone.presentation

import com.vro.compose.navigator.VROTemplateNavigator

open class ProfileOneTemplateNavigator<D : ProfileOneTemplateDestinations>() : VROTemplateNavigator<D>() {

    override fun navigate(destination: D) {
        when (destination) {
            ProfileOneTemplateDestinations.FollowDestination -> onProfileClick()
        }
    }

    open fun onProfileClick() = Unit
}