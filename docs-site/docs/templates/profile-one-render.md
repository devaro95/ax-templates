---
id: profile-one-render
title: Render
sidebar_label: Render
---

# Profile One Render

## ProfileOneTemplateRenderImpl - [Ver en GitHub](https://github.com/devaro95/ax-templates/blob/main/core/src/main/java/com/axtemplates/core/template/profile/profileone/presentation/render/ProfileOneTemplateRenderImpl.kt)




## 1. RenderHeaderSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render.png" alt="Captura" width="600" /></center>
    <br />
```kotlin
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
                  painter = painterResource(mapper.mapTopLeftIconId()),
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
                  painter = painterResource(mapper.mapTopRightIconId()),
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
```
  </details>

  ## 2. RenderInfoSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render-2.png" alt="Captura" width="600" /></center>
    <br />
    ```kotlin
    @Composable
    override fun RowScope.RenderInfoSection() {
        RenderLeftInfoSection()
        RenderCenterInfoSection()
        RenderRightInfoSection()
    }
    ```
  </details>

  ## 3. RenderLeftInfoSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render-3.png" alt="Captura" width="600" /></center>
    <br />
    ```kotlin
    @Composable
    override fun RowScope.RenderLeftInfoSection() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                fontWeight = FontWeight.Bold,
                text = mapper.mapFollowersValue(state.followers)
            )
            Text(
                text = stringResource(mapper.mapFollowersTextId())
            )
        }
    }
    ```
  </details>

  ## 4. RenderCenterInfoSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render-4.png" alt="Captura" width="600" /></center>
    <br />
    ```kotlin
    @Composable
    override fun RowScope.RenderCenterInfoSection() {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            model = mapper.mapAvatar(state),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
    ```
  </details>
  
  ## 5. RenderRightInfoSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render-5.png" alt="Captura" width="600" /></center>
    <br />
    ```kotlin
    @Composable
    override fun RowScope.RenderRightInfoSection() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                fontWeight = FontWeight.Bold,
                text = mapper.mapFollowingValue(state.following)
            )
            Text(
                text = stringResource(mapper.mapFollowingTextId())
            )
        }
    }
    ```
  </details>
    
  ## 6. RenderDescriptionSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render-6.png" alt="Captura" width="600" /></center>
    <br />
    ```kotlin
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
    ```
  </details>

  ## 7. RenderActionSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render-7.png" alt="Captura" width="600" /></center>
    <br />
    ```kotlin
    @Composable
    override fun RenderActionSection() {
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = { event(ProfileOneTemplateEvents.Message) },
            ) {
                Text(
                    text = stringResource(mapper.mapLeftButtonText()),
                    color = Color.White
                )
            }
            Button(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Black),
                onClick = { event(ProfileOneTemplateEvents.Follow) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(text = stringResource(mapper.mapRightButtonText()))
            }
        }
    }
    ```
  </details>

  ## 8. RenderGridSection
 <details>
    <summary>Show Code</summary>
    <br />
    <center><img src="/img/sample-template-render-8.png" alt="Captura" width="600" /></center>
    <br />
    ```kotlin
    @Composable
    override fun RenderGridSection() {
        Spacer(modifier = Modifier.height(24.dp))
        val chunkedList = mapper.mapGridImages(state).chunked(3)
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
    ```
  </details>