package com.axtemplates.core.template.profile.profileone.data.api

import com.axtemplates.core.api.AXApi
import com.axtemplates.core.template.profile.profileone.data.entity.ProfileOneEntity
import retrofit2.http.GET

interface ProfileOneApi : AXApi {
    @GET("classes/Profile")
    suspend fun getProfileOneData(): ProfileOneEntity
}