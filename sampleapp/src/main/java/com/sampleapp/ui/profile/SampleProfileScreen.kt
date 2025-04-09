package com.sampleapp.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.axtemplates.core.template.SampleTemplate
import com.axtemplates.core.template.SampleTemplateBase
import com.sampleapp.ui.base.SampleBaseScreen
import com.sampleapp.ui.subtemplate.SampleSubTemplate
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.compose.states.VROBottomBarBaseState
import com.vro.compose.states.VROBottomBarBaseState.VROBottomBarState
import com.vro.constants.INT_ONE
import org.koin.core.context.GlobalContext.get
import org.koin.core.qualifier.named

class SampleProfileScreen : SampleBaseScreen<SampleProfileState, SampleProfileEvents>() {

    override fun setBottomBar(currentState: VROBottomBarBaseState) =
        VROBottomBarState(selectedItem = INT_ONE)

    @Composable
    override fun ScreenContent(state: SampleProfileState) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            AddTemplate(SampleTemplate::class)
            AddTemplate(SampleSubTemplate::class)
        }
    }

    @VROLightMultiDevicePreview
    @Composable
    override fun ScreenPreview() {
        ScreenContent(state = SampleProfileState.INITIAL)
    }
}