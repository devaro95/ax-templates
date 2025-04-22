package com.axtemplates.core.template.profile.profileone.domain.repository

import com.axtemplates.core.repository.AXRepository
import com.axtemplates.core.template.profile.profileone.data.mapper.ProfileOneDataMapper

interface ProfileOneRepository : AXRepository {
    val mapper: ProfileOneDataMapper
}