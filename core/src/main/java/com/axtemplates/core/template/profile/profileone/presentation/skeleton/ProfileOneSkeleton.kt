package com.axtemplates.core.template.profile.profileone.presentation.skeleton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vro.compose.skeleton.VROSkeleton
import com.vro.compose.skeleton.vroSkeletonBrush

class ProfileOneSkeleton : VROSkeleton() {

    @Composable
    fun AXSkeletonBox(
        modifier: Modifier = Modifier,
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .background(vroSkeletonBrush(color = Color.Gray))
        )
    }

    @Composable
    fun AXSkeletonCircleBox(
        modifier: Modifier = Modifier,
    ) {
        Box(
            modifier = modifier
                .clip(CircleShape)
                .background(vroSkeletonBrush(color = Color.Gray))
        )
    }

    @Composable
    override fun SkeletonContent() {
        Column(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Box {
                AXSkeletonBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.White)
                        .align(Alignment.BottomCenter)
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    AXSkeletonBox(
                        modifier = Modifier
                            .height(40.dp)
                            .width(80.dp),
                    )
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(100.dp)
                    ) {
                        AXSkeletonCircleBox(
                            modifier = Modifier
                                .size(90.dp)
                                .align(Alignment.Center),
                        )
                    }
                    AXSkeletonBox(
                        modifier = Modifier
                            .height(40.dp)
                            .width(80.dp),
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                AXSkeletonBox(
                    modifier = Modifier
                        .width(80.dp)
                        .height(20.dp),
                )
                AXSkeletonBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                        .height(80.dp),
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                ) {
                    AXSkeletonBox(
                        modifier = Modifier
                            .height(40.dp)
                            .width(80.dp)
                    )
                    AXSkeletonBox(
                        modifier = Modifier
                            .height(40.dp)
                            .width(80.dp)
                    )
                }
            }
            Column(modifier = Modifier
                .padding(horizontal = 4.dp)
                .padding(top = 16.dp)) {
                repeat(2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(3) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp)
                            ) {
                                Column(
                                    modifier = Modifier.clip(RoundedCornerShape(8.dp))
                                ) {
                                    AXSkeletonBox(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .aspectRatio(1f)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    override fun SkeletonPreview() {
        SkeletonContent()
    }
}