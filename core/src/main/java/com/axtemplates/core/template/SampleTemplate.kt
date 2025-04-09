package com.axtemplates.core.template

import androidx.compose.runtime.Composable
import com.axtemplates.core.template.state.SampleTemplateState
import com.vro.compose.navigator.VROTemplateNav
import org.koin.core.component.KoinComponent

class SampleTemplate : SampleTemplateBase<SampleTemplateState, SampleTemplateDestinations>(), KoinComponent {

    override val navigator = scope.get<VROTemplateNav<SampleTemplateDestinations>>()

    @Composable
    override fun TemplatePreview() {

    }
}