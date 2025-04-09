package com.sampleapp.di

import com.axtemplates.core.template.*
import com.axtemplates.core.template.mapper.SampleTemplateMapper
import com.axtemplates.core.template.mapper.SampleTemplateMapperImpl
import com.axtemplates.core.template.state.SampleTemplateState
import com.sampleapp.ui.home.SampleHomeViewModel
import com.sampleapp.ui.profile.SampleProfileScreen
import com.sampleapp.ui.profile.SampleProfileViewModel
import com.sampleapp.ui.subtemplate.*
import com.sampleapp.ui.subtemplate.mapper.SampleSubTemplateMapper
import com.sampleapp.ui.subtemplate.mapper.SampleSubTemplateMapperImpl
import com.vro.compose.di.vroScopeName
import com.vro.compose.navigator.VROTemplateNav
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.scopedOf
import org.koin.dsl.bind
import org.koin.dsl.module

val cometPresentationModule = module {
    viewModelOf(::SampleHomeViewModel)
    viewModelOf(::SampleProfileViewModel)

    scope(vroScopeName<SampleProfileScreen>()) {
        scopedOf(::SampleSubTemplate)
        scopedOf(::SampleTemplate)
    }

    scope(vroScopeName<SampleTemplate>()) {
        scopedOf(::SampleTemplateMapperImpl) bind SampleTemplateMapper::class
        scoped { SampleTemplateNavigator<SampleTemplateDestinations>() } bind VROTemplateNav::class
        viewModel { SampleTemplateViewModel<SampleTemplateState, SampleTemplateDestinations>() }
    }

    scope(vroScopeName<SampleSubTemplate>()) {
        viewModelOf(::SampleSubTemplateViewModel)
        scopedOf(::SampleSubTemplateMapperImpl) bind SampleSubTemplateMapper::class
        scopedOf(::SampleSubTemplateNavigator) bind VROTemplateNav::class
    }
}