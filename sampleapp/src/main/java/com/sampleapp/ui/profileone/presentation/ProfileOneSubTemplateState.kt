package com.sampleapp.ui.profileone.presentation

import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneBaseState
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

data class ProfileOneSubTemplateState(
    override val imageList: List<String>,
    override val username: String,
    override val bio: String,
    override val avatar: String,
    override val userHeaderImage: String,
    override val followers: Int,
    override val following: Int,
    val text: String = EMPTY_STRING,
) : ProfileOneBaseState {

    override fun copy(
        username: String,
        bio: String,
        avatar: String,
        userHeaderImage: String,
        followers: Int,
        following: Int,
        imageList: List<String>,
    ): ProfileOneSubTemplateState {
        return ProfileOneSubTemplateState(
            username = username,
            bio = bio,
            avatar = avatar,
            userHeaderImage = userHeaderImage,
            followers = followers,
            following = following,
            imageList = imageList,
            text = text
        )
    }

    companion object {
        val INITIAL = ProfileOneSubTemplateState(
            username = EMPTY_STRING,
            bio = EMPTY_STRING,
            avatar = EMPTY_STRING,
            userHeaderImage = EMPTY_STRING,
            imageList = emptyList(),
            followers = INT_ZERO,
            following = INT_ZERO
        )
    }
}