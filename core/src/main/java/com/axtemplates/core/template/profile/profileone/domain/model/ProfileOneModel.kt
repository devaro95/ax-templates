package com.axtemplates.core.template.profile.profileone.domain.model

import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

open class ProfileOneModel(
    val username: String = EMPTY_STRING,
    val bio: String = EMPTY_STRING,
    val avatar: String = EMPTY_STRING,
    val userHeaderImage: String = EMPTY_STRING,
    val followers: Int = INT_ZERO,
    val following: Int = INT_ZERO,
    val imageList: List<String> = emptyList(),
)