package com.axtemplates.core.template

import com.vro.event.VROEvent

sealed class SampleTemplateEvents : VROEvent {
    data object Message : SampleTemplateEvents()
    data object Follow : SampleTemplateEvents()
}