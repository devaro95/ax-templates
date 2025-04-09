package com.axtemplates.core.template.state

import com.vro.state.VROState

interface SampleTemplateBaseState : VROState {
    val username: String
    val bio: String
    val followers: Int
    val following: Int
    val imageNumber: Int

    fun copy(
        username: String = this.username,
        bio: String = this.bio,
        followers: Int = this.followers,
        following: Int = this.following,
        imageNumber: Int = this.imageNumber,
    ): SampleTemplateBaseState
}