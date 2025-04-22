package com.axtemplates.core.template.profile.profileone.data.repository

import com.axtemplates.core.template.profile.profileone.data.mapper.ProfileOneDataMapper
import com.axtemplates.core.template.profile.profileone.data.mock.getProfileOneDataMock
import com.axtemplates.core.template.profile.profileone.domain.model.ProfileOneModel
import com.axtemplates.core.template.profile.profileone.domain.repository.ProfileOneRepository
import kotlinx.coroutines.delay

open class ProfileOneRepositoryImpl(
    override val mapper: ProfileOneDataMapper,
) : ProfileOneRepository {
    open suspend fun getInitialInfo(): ProfileOneModel {
        delay(2000L)
        return mapper.mapProfileOneData(getProfileOneDataMock())
    }
}