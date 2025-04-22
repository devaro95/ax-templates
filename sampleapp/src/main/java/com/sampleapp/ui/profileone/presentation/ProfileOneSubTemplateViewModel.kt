package com.sampleapp.ui.profileone.presentation

import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateDestinations
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateViewModel

class ProfileOneSubTemplateViewModel(
) : ProfileOneTemplateViewModel<ProfileOneSubTemplateState, ProfileOneTemplateDestinations>() {

    override val initialState: ProfileOneSubTemplateState = ProfileOneSubTemplateState.INITIAL

    override fun onFollowClick() {
        updateScreen {
            copy(
                text = "New Sub Template Bio"
            )
        }
        super.onFollowClick()
    }
}