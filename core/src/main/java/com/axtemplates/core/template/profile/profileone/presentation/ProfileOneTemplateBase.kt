package com.axtemplates.core.template.profile.profileone.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.axtemplates.core.template.profile.profileone.presentation.mapper.ProfileOneTemplateMapper
import com.axtemplates.core.template.profile.profileone.presentation.render.ProfileOneTemplateRender
import com.axtemplates.core.template.profile.profileone.presentation.render.ProfileOneTemplateRenderImpl
import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneBaseState
import com.vro.compose.di.injectViewModel
import com.vro.compose.template.VROTemplate
import org.koin.core.component.*

@Suppress("UNCHECKED_CAST")
abstract class ProfileOneTemplateBase<S : ProfileOneBaseState, D : ProfileOneTemplateDestinations>() : VROTemplate<
        ProfileOneTemplateViewModel<S, D>,
        S,
        D,
        ProfileOneTemplateEvents,
        ProfileOneTemplateMapper,
        ProfileOneTemplateRender<S>>(), KoinComponent {

    override val viewModel: ProfileOneTemplateViewModel<S, D> by injectViewModel()

    @Composable
    override fun render(state: S): ProfileOneTemplateRender<S> =
        remember(state) { ProfileOneTemplateRenderImpl(mapper = mapper, events = events, state = state) }

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

    @Composable
    override fun TemplatePreview() = Unit
}