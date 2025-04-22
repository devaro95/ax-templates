package com.axtemplates.core.template.profile.profileone.presentation

import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneBaseState
import com.axtemplates.core.template.profile.profileone.presentation.state.ProfileOneTemplateState
import com.axtemplates.core.template.profile.profileone.usecase.GetProfileOneDataUseCase
import com.vro.compose.template.VROTemplateViewModel
import com.vro.state.VROStepper.VROSkeletonStep
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class ProfileOneTemplateViewModel<S : ProfileOneBaseState, D : ProfileOneTemplateDestinations>(
) : VROTemplateViewModel<S, D, ProfileOneTemplateEvents>(), KoinComponent {

    override val initialState: S = ProfileOneTemplateState.Companion.INITIAL as S

    private val getProfileOneDataUseCase: GetProfileOneDataUseCase by inject()

    override fun onEvent(event: ProfileOneTemplateEvents) {
        when (event) {
            ProfileOneTemplateEvents.Message -> onMessageClick()
            ProfileOneTemplateEvents.Follow -> onFollowClick()
        }
    }

    override fun onStart() {
        executeCoroutine {
            showSkeleton()
            getProfileOneDataUseCase.execute(Unit).also {
                updateScreen {
                    copy(
                        bio = it.bio,
                        avatar = it.avatar,
                        imageList = it.imageList,
                        username = it.username,
                        followers = it.followers,
                        following = it.following,
                        userHeaderImage = it.userHeaderImage
                    ) as S
                }
            }
        }.onError {
            it
        }
    }

    open fun onFollowClick() {
        navigate(ProfileOneTemplateDestinations.FollowDestination as D)
    }

    open fun onMessageClick() = Unit

    fun showSkeleton() {
        observableStepper.tryEmit(VROSkeletonStep(screenState))
    }
}