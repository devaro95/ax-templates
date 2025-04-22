package com.sampleapp.ui.profileone.presentation.render

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateEvents
import com.axtemplates.core.template.profile.profileone.presentation.render.ProfileOneTemplateRenderImpl
import com.sampleapp.ui.profileone.presentation.ProfileOneSubTemplateState
import com.sampleapp.ui.profileone.presentation.mapper.ProfileOneSubTemplateMapper
import com.vro.event.VROEventLauncher

open class ProfileOneSubTemplateRenderImpl(
    override val state: ProfileOneSubTemplateState,
    override val mapper: ProfileOneSubTemplateMapper,
    override val events: VROEventLauncher<ProfileOneTemplateEvents>,
) : ProfileOneSubTemplateRender, ProfileOneTemplateRenderImpl<ProfileOneSubTemplateState>(mapper, events, state) {

    @Composable
    override fun RenderDescriptionSection() {
        Spacer(modifier = Modifier.height(16.dp))
        Text(state.text)
    }
}