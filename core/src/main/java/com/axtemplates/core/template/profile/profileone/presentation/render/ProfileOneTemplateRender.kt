package com.axtemplates.core.template.profile.profileone.presentation.render

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneBaseState
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateEvents
import com.vro.compose.template.VROTemplateRender

interface ProfileOneTemplateRender<S : ProfileOneBaseState> : VROTemplateRender<ProfileOneTemplateEvents, S> {
    @Composable
    fun BoxScope.RenderHeaderSection()

    @Composable
    fun RowScope.RenderInfoSection()

    @Composable
    fun RowScope.RenderLeftInfoSection()

    @Composable
    fun RowScope.RenderCenterInfoSection()

    @Composable
    fun RowScope.RenderRightInfoSection()

    @Composable
    fun RenderDescriptionSection()

    @Composable
    fun RenderActionSection()

    @Composable
    fun RenderGridSection()
}