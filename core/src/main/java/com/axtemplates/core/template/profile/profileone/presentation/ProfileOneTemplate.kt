package com.axtemplates.core.template.profile.profileone.presentation

import com.axtemplates.core.template.profile.profileone.presentation.mapper.ProfileOneTemplateMapper
import com.axtemplates.core.template.profile.profileone.presentation.skeleton.ProfileOneSkeleton
import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneTemplateState
import com.vro.compose.di.injectMapper
import com.vro.compose.di.injectNavigator
import com.vro.compose.skeleton.VROSkeleton
import org.koin.core.component.KoinComponent

class ProfileOneTemplate : ProfileOneTemplateBase<ProfileOneTemplateState, ProfileOneTemplateDestinations>(), KoinComponent {

    override val navigator by injectNavigator()

    override val skeleton: VROSkeleton = ProfileOneSkeleton()

    override val mapper: ProfileOneTemplateMapper by injectMapper()

}