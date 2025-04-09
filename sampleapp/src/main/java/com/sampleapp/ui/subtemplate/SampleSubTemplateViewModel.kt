package com.sampleapp.ui.subtemplate

import com.axtemplates.core.template.SampleTemplateDestinations
import com.axtemplates.core.template.SampleTemplateViewModel

class SampleSubTemplateViewModel : SampleTemplateViewModel<SampleSubTemplateState, SampleTemplateDestinations>() {

    override val initialState: SampleSubTemplateState = SampleSubTemplateState.INITIAL

    override fun onStart() {
        updateScreen {
            copy(
                text = "Sub Template Bio Change"
            )
        }
    }

    override fun onFollowClick() {
        updateScreen {
            copy(
                text = "New Sub Template Bio"
            )
        }
        super.onFollowClick()
    }
}