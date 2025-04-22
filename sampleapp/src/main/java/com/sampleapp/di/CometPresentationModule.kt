package com.sampleapp.di

import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplate
import com.sampleapp.ui.home.SampleHomeViewModel
import com.sampleapp.ui.profile.SampleProfileScreen
import com.sampleapp.ui.profile.SampleProfileViewModel
import com.sampleapp.ui.profileone.presentation.mapper.ProfileOneSubTemplateMapper
import com.sampleapp.ui.profileone.presentation.mapper.ProfileOneSubTemplateMapperImpl
import com.sampleapp.ui.profileone.presentation.ProfileOneSubTemplate
import com.sampleapp.ui.profileone.presentation.ProfileOneSubTemplateNavigator
import com.sampleapp.ui.profileone.presentation.ProfileOneSubTemplateViewModel
import com.vro.compose.navigator.VROTemplateNav
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.scopedOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val cometPresentationModule = module {
    viewModelOf(::SampleHomeViewModel)
    viewModelOf(::SampleProfileViewModel)

    scope(named<SampleProfileScreen>()) {
        scopedOf(::ProfileOneSubTemplate)
        scopedOf(::ProfileOneTemplate)
    }

    scope(named<ProfileOneSubTemplate>()) {
        viewModelOf(::ProfileOneSubTemplateViewModel)
        scopedOf(::ProfileOneSubTemplateMapperImpl) bind ProfileOneSubTemplateMapper::class
        scopedOf(::ProfileOneSubTemplateNavigator) bind VROTemplateNav::class
    }

    //singleOf(::ProfileOneSubTemplateRepositoryImpl) bind ProfileOneRepositoryImpl::class
}