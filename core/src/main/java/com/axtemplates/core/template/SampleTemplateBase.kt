package com.axtemplates.core.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.axtemplates.core.template.mapper.SampleTemplateMapper
import com.axtemplates.core.template.render.SampleTemplateRender
import com.axtemplates.core.template.render.SampleTemplateRenderImpl
import com.axtemplates.core.template.state.SampleTemplateBaseState
import com.vro.compose.di.injectMapper
import com.vro.compose.template.VROTemplate
import org.koin.core.component.inject

@Suppress("UNCHECKED_CAST")
abstract class SampleTemplateBase<S : SampleTemplateBaseState, D : SampleTemplateDestinations>() : VROTemplate<
        SampleTemplateViewModel<S, D>,
        S,
        D,
        SampleTemplateEvents,
        SampleTemplateMapper,
        SampleTemplateRender<S>>() {

    override val viewModel: SampleTemplateViewModel<S, D> by inject()

    override fun mapper() = injectMapper<SampleTemplateMapper>()

    @Composable
    override fun render(state: S): SampleTemplateRender<S> =
        remember(state) { SampleTemplateRenderImpl(mapper = mapper(), events = events, state = state) }

    @Composable
    override fun TemplateContent(state: S) {
        render(state).apply {
            Column(
                modifier = Modifier
                    .padding(bottom = 16.dp)
            ) {
                Box {
                    RenderHeaderSection()
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        RenderInfoSection()
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    RenderDescriptionSection()
                    RenderActionSection()
                }
                RenderGridSection()
            }
        }
    }
}