package com.sampleapp.ui.profile

import androidx.navigation.NavController
import com.sampleapp.ui.profile.SampleProfileNavigator.SampleProfileDestinations
import com.vro.compose.VROComposableActivity
import com.vro.compose.navigator.VROComposableNavigator
import com.vro.navigation.VRODestination

class SampleProfileNavigator(
    activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<SampleProfileDestinations>(activity, navController) {

    override fun navigate(destination: SampleProfileDestinations) {

    }

    sealed class SampleProfileDestinations : VRODestination() {
        data object ProfileNavigation : SampleProfileDestinations()
    }
}