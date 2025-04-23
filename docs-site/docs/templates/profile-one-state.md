---
id: profile-one-state
title: State
sidebar_label: State
---

# Profile One State

## ProfileOneTemplateState - [Ver en GitHub](https://github.com/devaro95/ax-templates/blob/main/core/src/main/java/com/axtemplates/core/template/profile/profileone/presentation/state/ProfileOneTemplateState.kt)

```kotlin
open class ProfileOneTemplateState(
    override val username: String = EMPTY_STRING,
    override val bio: String = EMPTY_STRING,
    override val avatar: String = EMPTY_STRING,
    override val userHeaderImage: String = EMPTY_STRING,
    override val followers: Int = INT_ZERO,
    override val following: Int = INT_ZERO,
    override val imageList: List<String> = emptyList(),
) : ProfileOneBaseState {

    override fun copy(
        username: String,
        bio: String,
        avatar: String,
        userHeaderImage: String,
        followers: Int,
        following: Int,
        imageList: List<String>,
    ): ProfileOneTemplateState {
        return ProfileOneTemplateState(
            username = username,
            bio = bio,
            avatar = avatar,
            userHeaderImage = userHeaderImage,
            followers = followers,
            following = following,
            imageList = imageList
        )
    }

    companion object {
        val INITIAL = ProfileOneTemplateState(
            username = EMPTY_STRING,
            bio = EMPTY_STRING,
            avatar = EMPTY_STRING,
            imageList = emptyList(),
            followers = INT_ZERO,
            following = INT_ZERO
        )
    }
}
```