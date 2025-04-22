package com.sampleapp.ui.profileone.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateBase
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateDestinations
import com.sampleapp.ui.profileone.presentation.mapper.ProfileOneSubTemplateMapper
import com.sampleapp.ui.profileone.presentation.render.ProfileOneSubTemplateRenderImpl
import com.vro.compose.di.*
import com.vro.compose.navigator.VROTemplateNav
import org.koin.core.component.KoinComponent

class ProfileOneSubTemplate() : ProfileOneTemplateBase<ProfileOneSubTemplateState, ProfileOneTemplateDestinations>(), KoinComponent {

    override val viewModel: ProfileOneSubTemplateViewModel by injectViewModel()

    override val navigator: VROTemplateNav<ProfileOneTemplateDestinations> by injectNavigator()

    override val mapper: ProfileOneSubTemplateMapper by injectMapper()

    @Composable
    override fun render(state: ProfileOneSubTemplateState): ProfileOneSubTemplateRenderImpl =
        remember(state) { ProfileOneSubTemplateRenderImpl(mapper = mapper, events = events, state = state) }

    @Composable
    override fun TemplatePreview() {

    }
}