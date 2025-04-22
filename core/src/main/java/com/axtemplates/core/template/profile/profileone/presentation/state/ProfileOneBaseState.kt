package com.axtemplates.core.template.profile.profileone.presentation.state

import com.vro.state.VROState

interface ProfileOneBaseState : VROState {
    val username: String
    val bio: String
    val avatar: String
    val userHeaderImage: String
    val followers: Int
    val following: Int
    val imageList: List<String>

    fun copy(
        username: String = this.username,
        bio: String = this.bio,
        avatar: String = this.avatar,
        userHeaderImage: String = this.userHeaderImage,
        followers: Int = this.followers,
        following: Int = this.following,
        imageList: List<String> = this.imageList,
    ): ProfileOneBaseState
}