package com.sampleapp.ui.subtemplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.axtemplates.core.template.SampleTemplateBase
import com.axtemplates.core.template.SampleTemplateDestinations
import com.sampleapp.ui.subtemplate.mapper.SampleSubTemplateMapper
import com.sampleapp.ui.subtemplate.render.SampleSubTemplateRenderImpl
import com.vro.compose.di.injectMapper
import com.vro.compose.di.injectNavigator
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext.get
import org.koin.core.qualifier.named

class SampleSubTemplate() : SampleTemplateBase<SampleSubTemplateState, SampleTemplateDestinations>() {

    override val scope = get().getScopeOrNull(this::class.toString()) ?: get().createScope(this::class.toString(), named(this::class.toString()))

    override val viewModel: SampleSubTemplateViewModel by inject()

    override fun mapper() = injectMapper<SampleSubTemplateMapper>()

    override val navigator = injectNavigator()

    @Composable
    override fun render(state: SampleSubTemplateState): SampleSubTemplateRenderImpl =
        remember(state) { SampleSubTemplateRenderImpl(mapper = mapper(), events = events, state = state) }

    @Composable
    override fun TemplatePreview() {

    }
}