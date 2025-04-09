package com.sampleapp.ui.subtemplate

import com.axtemplates.core.template.state.SampleTemplateBaseState
import com.vro.constants.EMPTY_STRING

data class SampleSubTemplateState(
    override val imageNumber: Int,
    override val username: String,
    override val bio: String,
    override val followers: Int,
    override val following: Int,
    val text: String = EMPTY_STRING,
) : SampleTemplateBaseState {

    override fun copy(
        username: String,
        bio: String,
        followers: Int,
        following: Int,
        imageNumber: Int,
    ): SampleSubTemplateState {
        return SampleSubTemplateState(
            username = username,
            bio = bio,
            followers = followers,
            following = following,
            imageNumber = imageNumber,
            text = text
        )
    }

    companion object {
        val INITIAL = SampleSubTemplateState(
            username = "Subtemplate Varo95m",
            bio = "This is the subtemplate user bio",
            imageNumber = 3,
            followers = 150,
            following = 2500
        )
    }
}