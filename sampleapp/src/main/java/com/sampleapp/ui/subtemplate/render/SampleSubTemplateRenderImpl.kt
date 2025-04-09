package com.sampleapp.ui.subtemplate.render

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axtemplates.core.template.SampleTemplateEvents
import com.axtemplates.core.template.render.SampleTemplateRenderImpl
import com.sampleapp.ui.subtemplate.SampleSubTemplateState
import com.sampleapp.ui.subtemplate.mapper.SampleSubTemplateMapper
import com.vro.event.VROEventLauncher

open class SampleSubTemplateRenderImpl(
    override val state: SampleSubTemplateState,
    override val mapper: SampleSubTemplateMapper,
    override val events: VROEventLauncher<SampleTemplateEvents>,
) : SampleSubTemplateRender, SampleTemplateRenderImpl<SampleSubTemplateState>(mapper, events, state) {

    @Composable
    override fun RenderDescriptionSection() {
        Spacer(modifier = Modifier.height(16.dp))
        Text(state.text)
    }
}