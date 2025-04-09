package com.axtemplates.core.template.render

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.axtemplates.core.template.state.SampleTemplateBaseState
import com.axtemplates.core.template.SampleTemplateEvents
import com.vro.compose.template.VROTemplateRender

interface SampleTemplateRender<S : SampleTemplateBaseState> : VROTemplateRender<SampleTemplateEvents, S> {
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