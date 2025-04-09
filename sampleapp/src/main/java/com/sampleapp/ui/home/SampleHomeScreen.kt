package com.sampleapp.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sampleapp.R
import com.sampleapp.topbar.sampleBackToolbar
import com.sampleapp.ui.base.SampleBaseScreen
import com.vro.compose.skeleton.VROSkeleton
import com.vro.compose.states.VROBottomBarBaseState
import com.vro.compose.states.VROBottomBarBaseState.VROBottomBarState
import com.vro.compose.states.VROTopBarBaseState
import com.vro.compose.utils.vroVerticalScroll
import com.vro.constants.INT_ZERO

class SampleHomeScreen(
    override val skeleton: VROSkeleton = SampleHomeSkeleton(),
) : SampleBaseScreen<SampleHomeState, SampleHomeEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) = sampleBackToolbar(
        title = context.getString(R.string.home_toolbar),
        onNavigation = { navigateBack() }
    )

    override fun setBottomBar(currentState: VROBottomBarBaseState) =
        VROBottomBarState(selectedItem = INT_ZERO)

    @Composable
    override fun ScreenContent(state: SampleHomeState) {
        Column(
            modifier = Modifier
                .vroVerticalScroll()
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedButton(
                modifier = Modifier.padding(top = 16.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                onClick = { event((SampleHomeEvents.Profile)) }
            ) {
                Text(text = "Profile Navigation")
            }
        }
    }

    @Composable
    override fun ScreenPreview() {
        ScreenContent(SampleHomeState.INITIAL)
    }
}