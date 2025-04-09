package com.axtemplates.core.template.render

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
import com.axtemplates.core.template.SampleTemplateEvents
import com.axtemplates.core.template.mapper.SampleTemplateMapper
import com.axtemplates.core.template.state.SampleTemplateBaseState
import com.core.R
import com.vro.event.VROEventLauncher

open class SampleTemplateRenderImpl<S : SampleTemplateBaseState>(
    open val mapper: SampleTemplateMapper,
    override val events: VROEventLauncher<SampleTemplateEvents>,
    override val state: S,
) : SampleTemplateRender<S> {

    @Composable
    override fun BoxScope.RenderHeaderSection() {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            painter = painterResource(R.drawable.header),
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
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.ic_avatar_avocado),
            contentDescription = null,
            contentScale = ContentScale.Crop
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
                onClick = { event(SampleTemplateEvents.Message) },
            ) {
                Text(
                    text = mapper.mapLeftButtonText(),
                    color = Color.White
                )
            }
            Button(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Black),
                onClick = { event(SampleTemplateEvents.Follow) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(text = mapper.mapRightButtonText())
            }
        }
    }

    @Composable
    override fun RenderGridSection() {
        Spacer(modifier = Modifier.height(24.dp))
        val generatedList = List(state.imageNumber) { it }
        val chunkedList = generatedList.chunked(3)
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
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f)
                                        .clip(RoundedCornerShape(8.dp)),
                                    painter = painterResource(R.drawable.header),
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