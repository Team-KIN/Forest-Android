package com.kin.data.remote.datasource.group_list

import com.kin.data.remote.dto.group_list.response.GroupListResponse
import kotlinx.coroutines.flow.Flow

interface GroupListDataSource {
    suspend fun getGroupList(): Flow<GroupListResponse>
}