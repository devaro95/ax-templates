package com.axtemplates.core.template.mapper

import com.axtemplates.core.template.state.SampleTemplateBaseState
import com.core.R
import com.vro.compose.template.VROTemplateMapper
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

interface SampleTemplateMapper : VROTemplateMapper {
    fun mapTopLeftIcon(): Int {
        return R.drawable.ic_arrow
    }

    fun mapTopRightIcon(): Int {
        return R.drawable.ic_profile
    }

    fun mapUsername(state: SampleTemplateBaseState): String {
        return state.username
    }

    fun mapBio(state: SampleTemplateBaseState): String {
        return state.bio
    }

    fun mapFollowersText(): String {
        return "Followers"
    }

    fun mapFollowingText(): String {
        return "Following"
    }

    fun mapFollowersValue(followers: Int): String {
        return mapValue(followers)
    }

    fun mapFollowingValue(following: Int): String {
        return mapValue(following)
    }

    private fun mapValue(value: Int): String {
        return when {
            value >= MILLION -> {
                val millions = value / MILLION.toFloat()
                if (value % MILLION == INT_ZERO) "${millions.toInt()}M"
                else MILLION_FORMAT.format(millions).replace(POINT_ZERO, EMPTY_STRING)
            }

            value >= TEN_THOUSAND -> {
                val thousands = value / THOUSAND.toFloat()
                if (value % THOUSAND == INT_ZERO) "${thousands.toInt()}k"
                else THOUSAND_FORMAT.format(thousands).replace(POINT_ZERO, EMPTY_STRING)
            }

            else -> value.toString()
        }
    }

    fun mapLeftButtonText(): String {
        return "Follow"
    }

    fun mapRightButtonText(): String {
        return "Message"
    }

    companion object {
        private const val MILLION = 1_000_000
        private const val THOUSAND = 1_000
        private const val TEN_THOUSAND = 10_000
        private const val MILLION_FORMAT = "%.1fM"
        private const val THOUSAND_FORMAT = "%.1fk"
        private const val POINT_ZERO = ".0"
    }
}