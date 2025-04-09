package com.sampleapp.ui.home

import com.sampleapp.ui.home.SampleHomeEvents.Profile
import com.sampleapp.ui.home.SampleHomeNavigator.SampleHomeDestinations
import com.vro.compose.VROComposableViewModel

class SampleHomeViewModel : VROComposableViewModel<SampleHomeState, SampleHomeDestinations, SampleHomeEvents>() {

    override val initialState: SampleHomeState = SampleHomeState.INITIAL

    override fun onEvent(event: SampleHomeEvents) {
        when (event) {
            Profile -> navigateToProfile()
        }
    }

    override fun onStart() {
        updateScreen()
    }

    private fun navigateToProfile() {
        navigate(SampleHomeDestinations.ProfileNavigation)
    }
}