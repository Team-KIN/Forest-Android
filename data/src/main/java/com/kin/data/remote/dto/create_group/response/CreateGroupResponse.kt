package com.kin.data.remote.dto.create_group.response

import com.kin.domain.model.create_group.response.CreateGroupResponseModel

data class CreateGroupResponse (
    val code: String
)

fun CreateGroupResponse.toCreateGroupModel() =
    CreateGroupResponseModel(
        code = this.code
    )