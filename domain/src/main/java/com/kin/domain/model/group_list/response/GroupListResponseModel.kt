package com.kin.domain.model.group_list.response

import java.util.UUID

data class GroupListResponseModel(
    val groups: List<GroupListModel>
)
data class GroupListModel(
    val id: UUID,
    val name: String,
    val headcount: Int,
    val todo: Int
)