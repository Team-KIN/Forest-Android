package com.kin.data.remote.dto.create_group.request

data class CreateGroupRequest(
    val name: String,
    val content: String,
    val purpose: String
)