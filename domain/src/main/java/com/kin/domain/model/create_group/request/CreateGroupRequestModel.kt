package com.kin.domain.model.create_group.request

data class CreateGroupRequestModel(
    val name: String,
    val content: String,
    val purpose: String
)