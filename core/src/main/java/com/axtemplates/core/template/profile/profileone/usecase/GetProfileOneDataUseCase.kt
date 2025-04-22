package com.axtemplates.core.template.profile.profileone.usecase

import com.axtemplates.core.template.profile.profileone.domain.model.ProfileOneModel
import com.axtemplates.core.template.profile.profileone.data.repository.ProfileOneRepositoryImpl
import com.vro.usecase.VROUseCase

class GetProfileOneDataUseCase(private val repository: ProfileOneRepositoryImpl) : VROUseCase<Unit, ProfileOneModel>() {
    override suspend fun useCaseFunction(input: Unit): ProfileOneModel {
        return repository.getInitialInfo()
    }
}