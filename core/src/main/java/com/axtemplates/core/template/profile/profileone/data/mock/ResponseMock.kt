package com.axtemplates.core.template.profile.profileone.data.mock

import com.axtemplates.core.template.profile.profileone.data.entity.ProfileOneEntity

fun getProfileOneDataMock() = ProfileOneEntity(
    username = "astroUser",
    bio = "astroUser Bio mock",
    avatar = "https://img.freepik.com/premium-vector/person-with-blue-shirt-that-says-name-person_1029948-7040.jpg",
    followers = 100100101,
    following = 318924817,
    userHeaderImage = "https://www.dzoom.org.es/wp-content/uploads/2017/07/seebensee-2384369-810x540.jpg",
    imageList = listOf("https://images.unsplash.com/photo-1506260408121-e353d10b87c7?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8cGFpc2FqZXxlbnwwfHwwfHx8MA%3D%3D")
)