package com.kin.data.remote.datasource.create_group

import com.kin.data.remote.dto.create_group.request.CreateGroupRequest
import com.kin.data.remote.dto.create_group.response.CreateGroupResponse
import kotlinx.coroutines.flow.Flow

interface CreateGroupDataSource {

    suspend fun createGroup(body: CreateGroupRequest): Flow<CreateGroupResponse>
}