package com.sampleapp.ui.home

import com.vro.event.VROEvent

sealed class SampleHomeEvents : VROEvent {
    data object Profile : SampleHomeEvents()
}