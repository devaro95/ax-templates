package com.sampleapp.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplate
import com.sampleapp.ui.base.SampleBaseScreen
import com.sampleapp.ui.profileone.presentation.ProfileOneSubTemplate
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.compose.states.VROBottomBarBaseState
import com.vro.compose.states.VROBottomBarBaseState.VROBottomBarState
import com.vro.constants.INT_ONE
import org.koin.core.component.createScope
import org.koin.core.scope.Scope

class SampleProfileScreen : SampleBaseScreen<SampleProfileState, SampleProfileEvents>() {

    override val scope: Scope by lazy { createScope(this) }

    override fun setBottomBar(currentState: VROBottomBarBaseState) =
        VROBottomBarState(selectedItem = INT_ONE)

    @Composable
    override fun ScreenContent(state: SampleProfileState) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            AddTemplate(ProfileOneTemplate::class)
        }
    }

    @VROLightMultiDevicePreview
    @Composable
    override fun ScreenPreview() {
        ScreenContent(state = SampleProfileState.INITIAL)
    }
}