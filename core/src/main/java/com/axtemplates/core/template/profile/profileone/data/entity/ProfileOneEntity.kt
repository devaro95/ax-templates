package com.axtemplates.core.template.profile.profileone.data.entity

import com.google.gson.annotations.SerializedName
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

data class ProfileOneEntity(
    @SerializedName("username")
    val username: String = EMPTY_STRING,
    @SerializedName("bio")
    val bio: String = EMPTY_STRING,
    @SerializedName("avatar")
    val avatar: String = EMPTY_STRING,
    @SerializedName("followers")
    val followers: Int = INT_ZERO,
    @SerializedName("following")
    val following: Int = INT_ZERO,
    @SerializedName("userHeaderImage")
    val userHeaderImage: String = EMPTY_STRING,
    @SerializedName("imageList")
    val imageList: List<String> = emptyList(),
)