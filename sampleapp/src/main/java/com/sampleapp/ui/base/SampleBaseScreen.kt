package com.sampleapp.ui.base

import com.vro.compose.screen.VROScreen
import com.vro.event.VROEvent
import com.vro.state.VROState

abstract class SampleBaseScreen<S : VROState, E : VROEvent> : VROScreen<S, E>()