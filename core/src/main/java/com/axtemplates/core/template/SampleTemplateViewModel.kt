package com.axtemplates.core.template

import com.axtemplates.core.template.SampleTemplateDestinations.FollowDestination
import com.axtemplates.core.template.state.SampleTemplateBaseState
import com.axtemplates.core.template.state.SampleTemplateState
import com.vro.compose.template.VROTemplateViewModel

open class SampleTemplateViewModel<S : SampleTemplateBaseState, D : SampleTemplateDestinations>() : VROTemplateViewModel<S, D, SampleTemplateEvents>() {

    override val initialState: S = SampleTemplateState.INITIAL as S

    override fun onEvent(event: SampleTemplateEvents) {
        when (event) {
            SampleTemplateEvents.Message -> onMessageClick()
            SampleTemplateEvents.Follow -> onFollowClick()
        }
    }

    open fun onFollowClick() {
        navigate(FollowDestination as D)
    }

    open fun onMessageClick() {
        val random = (1..10).random()
        updateScreen {
            copy(
                imageNumber = random
            ) as S
        }
    }
}