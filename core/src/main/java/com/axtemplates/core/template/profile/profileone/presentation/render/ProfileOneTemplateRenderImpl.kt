package com.axtemplates.core.template.profile.profileone.presentation.render

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.axtemplates.core.template.profile.profileone.presentation.ProfileOneTemplateEvents
import com.axtemplates.core.template.profile.profileone.presentation.mapper.ProfileOneTemplateMapper
import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneBaseState
import com.vro.event.VROEventLauncher

open class ProfileOneTemplateRenderImpl<S : ProfileOneBaseState>(
    open val mapper: ProfileOneTemplateMapper,
    override val events: VROEventLauncher<ProfileOneTemplateEvents>,
    override val state: S,
) : ProfileOneTemplateRender<S> {

    @Composable
    override fun BoxScope.RenderHeaderSection() {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            model = state.userHeaderImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .graphicsLayer { alpha = 0.8f }
                        .background(Color.White)
                        .size(35.dp)
                        .clickable {
                            doBack()
                        }
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(20.dp),
                        painter = painterResource(mapper.mapTopLeftIcon()),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
            Column {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .graphicsLayer { alpha = 0.8f }
                        .background(Color.White)
                        .size(35.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(20.dp),
                        painter = painterResource(mapper.mapTopRightIcon()),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White)
                .align(Alignment.BottomCenter)
        )
    }

    @Composable
    override fun RowScope.RenderInfoSection() {
        RenderLeftInfoSection()
        RenderCenterInfoSection()
        RenderRightInfoSection()
    }

    @Composable
    override fun RowScope.RenderLeftInfoSection() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                fontWeight = FontWeight.Bold,
                text = mapper.mapFollowersValue(state.followers)
            )
            Text(
                text = mapper.mapFollowersText()
            )
        }
    }

    @Composable
    override fun RowScope.RenderCenterInfoSection() {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            model = state.avatar,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }

    @Composable
    override fun RowScope.RenderRightInfoSection() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                fontWeight = FontWeight.Bold,
                text = mapper.mapFollowingValue(state.following)
            )
            Text(
                text = mapper.mapFollowingText()
            )
        }
    }

    @Composable
    override fun RenderDescriptionSection() {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = mapper.mapUsername(state),
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(horizontal = 60.dp),
            text = mapper.mapBio(state),
            textAlign = TextAlign.Center
        )
    }

    @Composable
    override fun RenderActionSection() {
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = { event(ProfileOneTemplateEvents.Message) },
            ) {
                Text(
                    text = mapper.mapLeftButtonText(),
                    color = Color.White
                )
            }
            Button(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Black),
                onClick = { event(ProfileOneTemplateEvents.Follow) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(text = mapper.mapRightButtonText())
            }
        }
    }

    @Composable
    override fun RenderGridSection() {
        Spacer(modifier = Modifier.height(24.dp))
        val chunkedList = state.imageList.chunked(3)
        Column(modifier = Modifier.padding(horizontal = 4.dp)) {
            chunkedList.forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    rowItems.forEach { item ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(2.dp)
                        ) {
                            Column(
                                modifier = Modifier.clip(RoundedCornerShape(8.dp))
                            ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f)
                                        .clip(RoundedCornerShape(8.dp)),
                                    model = item,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    repeat(3 - rowItems.size) {
                        Box(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}