package com.sampleapp.ui.profile

import com.sampleapp.ui.profile.SampleProfileNavStarter.Initialize
import com.sampleapp.ui.profile.SampleProfileNavigator.SampleProfileDestinations
import com.vro.compose.VROComposableViewModel
import com.vro.navstarter.VRONavStarter

class SampleProfileViewModel : VROComposableViewModel<SampleProfileState, SampleProfileDestinations, SampleProfileEvents>() {

    override val initialState: SampleProfileState = SampleProfileState.INITIAL

    override fun onEvent(event: SampleProfileEvents) = Unit

    override fun onStarter(starter: VRONavStarter?) {
        when (starter) {
            is Initialize -> updateScreen { copy(userId = starter.userId) }
        }
    }
}