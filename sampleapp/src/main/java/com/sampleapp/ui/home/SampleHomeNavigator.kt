package com.sampleapp.ui.home

import androidx.navigation.NavController
import com.sampleapp.ui.home.SampleHomeNavigator.SampleHomeDestinations
import com.sampleapp.ui.home.SampleHomeNavigator.SampleHomeDestinations.ProfileNavigation
import com.sampleapp.ui.profile.SampleProfileScreen
import com.vro.compose.VROComposableActivity
import com.vro.compose.navigator.VROComposableNavigator
import com.vro.navigation.VRODestination

class SampleHomeNavigator(
    override val activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<SampleHomeDestinations>(activity, navController) {

    override fun navigate(destination: SampleHomeDestinations) {
        when (destination) {
            ProfileNavigation -> navigateToScreen(SampleProfileScreen())
        }
    }

    sealed class SampleHomeDestinations : VRODestination() {
        data object ProfileNavigation : SampleHomeDestinations()
    }
}