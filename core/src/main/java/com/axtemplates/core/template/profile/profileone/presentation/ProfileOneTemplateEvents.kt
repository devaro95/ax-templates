package com.axtemplates.core.template.profile.profileone.presentation

import com.vro.event.VROEvent

sealed class ProfileOneTemplateEvents : VROEvent {
    data object Message : ProfileOneTemplateEvents()
    data object Follow : ProfileOneTemplateEvents()
}