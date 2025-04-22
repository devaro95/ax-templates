package com.axtemplates.core.template.profile.profileone.data.mapper

import com.axtemplates.core.template.profile.profileone.data.entity.ProfileOneEntity
import com.axtemplates.core.template.profile.profileone.domain.model.ProfileOneModel

class ProfileOneDataMapper {
    fun mapProfileOneData(entity: ProfileOneEntity): ProfileOneModel {
        return ProfileOneModel(
            username = entity.username,
            bio = entity.bio,
            avatar = entity.avatar,
            followers = entity.followers,
            following = entity.following,
            imageList = entity.imageList,
            userHeaderImage = entity.userHeaderImage
        )
    }
}