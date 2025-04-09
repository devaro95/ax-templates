package com.axtemplates.core.template.state

import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

open class SampleTemplateState(
    override val username: String = EMPTY_STRING,
    override val bio: String = EMPTY_STRING,
    override val followers: Int = INT_ZERO,
    override val following: Int = INT_ZERO,
    override val imageNumber: Int = INT_ZERO,
) : SampleTemplateBaseState {

    override fun copy(
        username: String,
        bio: String,
        followers: Int,
        following: Int,
        imageNumber: Int,
    ): SampleTemplateState {
        return SampleTemplateState(
            username = username,
            bio = bio,
            followers = followers,
            following = following,
            imageNumber = imageNumber
        )
    }

    companion object {
        val INITIAL = SampleTemplateState(
            username = "Template Varo95m",
            bio = "This is the template user bio",
            imageNumber = 5,
            followers = 150,
            following = 2500
        )
    }
}