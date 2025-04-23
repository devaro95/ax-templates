---
id: profile-one-mapper
title: Mapper
sidebar_label: Mapper
---

# Profile One Mapper

## ProfileOneTemplateMapperImpl - [Ver en GitHub](https://github.com/devaro95/ax-templates/blob/main/core/src/main/java/com/axtemplates/core/template/profile/profileone/presentation/mapper/ProfileOneTemplateMapperImpl.kt)



<center>
  <img src="/img/sample-template.png" alt="Captura" width="300" />
</center>
<br />

| Nº  | Mapper function                                         | Return Value                                                                |
|-----|--------------------------------------------------|-----------------------------------------------------------------------------|
| 1   | `mapTopLeftIconId()`                             | Returns `R.drawable.ic_arrow` by default                                   |
| 2   | `mapTopRightIconId()`                            | Returns `R.drawable.ic_profile` by default                                 |
| 3   | `mapFollowersValue(followers: Int)`              | Returns `followers` mapped with M (millions) and K (thousands)             |
| 4   | `mapFollowersTextId()`                           | Returns `R.string.profile_one_template_followers` by default               |
| 5   | `mapAvatar(state: ProfileOneBaseState)`          | Returns `state.avatar`                                                     |
| 6   | `mapFollowingValue(following: Int)`              | Returns `following` mapped with M (millions) and K (thousands)             |
| 7   | `mapFollowingTextId()`                           | Returns `R.string.profile_one_template_following` by default               |
| 8   | `mapUsername(state: ProfileOneBaseState)`        | Returns `state.username`                                                   |
| 9   | `mapBio(state: ProfileOneBaseState)`             | Returns `state.bio`                                                        |
| 10  | `mapLeftButtonText()`                            | Returns `R.string.profile_one_template_follow` by default                  |
| 11  | `mapRightButtonText()`                           | Returns `R.string.profile_one_template_message` by default                 |
| 12  | `mapGridImages(state: ProfileOneBaseState)`      | Returns `state.imageList`                                                  |
