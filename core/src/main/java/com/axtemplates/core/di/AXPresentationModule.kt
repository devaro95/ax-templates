package com.axtemplates.core.di

import com.axtemplates.core.template.profile.profileone.data.mapper.ProfileOneDataMapper
import com.axtemplates.core.template.profile.profileone.data.repository.ProfileOneRepositoryImpl
import com.axtemplates.core.template.profile.profileone.presentation.*
import com.axtemplates.core.template.profile.profileone.presentation.mapper.ProfileOneTemplateMapper
import com.axtemplates.core.template.profile.profileone.presentation.mapper.ProfileOneTemplateMapperImpl
import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneTemplateState
import com.axtemplates.core.template.profile.profileone.usecase.GetProfileOneDataUseCase
import com.vro.compose.navigator.VROTemplateNav
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.scopedOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val axPresentationModule = module {

    singleOf(::ProfileOneRepositoryImpl)
    singleOf(::GetProfileOneDataUseCase)
    singleOf(::ProfileOneDataMapper)

    scope(named<ProfileOneTemplate>()) {
        scopedOf(::ProfileOneTemplateMapperImpl) bind ProfileOneTemplateMapper::class
        scoped { ProfileOneTemplateNavigator<ProfileOneTemplateDestinations>() } bind VROTemplateNav::class
        viewModel { ProfileOneTemplateViewModel<ProfileOneTemplateState, ProfileOneTemplateDestinations>() }
    }
}