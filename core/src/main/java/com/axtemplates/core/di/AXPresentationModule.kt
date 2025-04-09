package com.axtemplates.core.di

import com.axtemplates.core.template.*
import com.axtemplates.core.template.mapper.SampleTemplateMapper
import com.axtemplates.core.template.mapper.SampleTemplateMapperImpl
import com.axtemplates.core.template.state.SampleTemplateState
import com.vro.compose.di.vroScopeName
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.scopedOf
import org.koin.dsl.bind
import org.koin.dsl.module

val axPresentationModule = module {
    scope(vroScopeName<SampleTemplateBase<SampleTemplateState, SampleTemplateDestinations>>()) {
        scopedOf(::SampleTemplateMapperImpl) bind SampleTemplateMapper::class
        viewModel { SampleTemplateViewModel<SampleTemplateState, SampleTemplateDestinations>() }
    }
}