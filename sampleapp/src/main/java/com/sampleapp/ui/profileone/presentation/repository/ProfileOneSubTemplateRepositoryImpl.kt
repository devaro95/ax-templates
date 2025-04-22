package com.sampleapp.ui.profileone.presentation.repository

import com.axtemplates.core.template.profile.profileone.data.mapper.ProfileOneDataMapper
import com.axtemplates.core.template.profile.profileone.data.repository.ProfileOneRepositoryImpl
import com.axtemplates.core.template.profile.profileone.domain.model.ProfileOneModel

class ProfileOneSubTemplateRepositoryImpl(
    mapper: ProfileOneDataMapper
) : ProfileOneRepositoryImpl(mapper) {
    override suspend fun getInitialInfo(): ProfileOneModel {
        return ProfileOneModel(imageList = emptyList())
    }
}