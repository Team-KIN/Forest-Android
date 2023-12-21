package com.kin.data.remote.dto.group_list.response

import com.kin.domain.model.group_list.response.GroupListResponseModel
import com.kin.domain.model.group_list.response.GroupListModel
import java.util.UUID

data class GroupListResponse(
    val groups: List<GroupList>
)
data class GroupList (
    val id: UUID,
    val name: String,
    val headcount: Int,
    val todo: Int
)

fun GroupListResponse.toGroupListModel() =
    GroupListResponseModel(
        groups = this.groups.map { it.toGroupListModel() }
    )
fun GroupList.toGroupListModel() =
    GroupListModel(
        id = this.id,
        name = this.name,
        headcount = this.headcount,
        todo = this.todo
    )