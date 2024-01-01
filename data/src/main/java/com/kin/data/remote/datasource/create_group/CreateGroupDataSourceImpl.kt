package com.kin.data.remote.datasource.create_group

import com.kin.data.remote.api.create_group.CreateGroupAPI
import com.kin.data.remote.dto.create_group.request.CreateGroupRequest
import com.kin.data.remote.dto.create_group.response.CreateGroupResponse
import com.kin.data.util.ForestApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CreateGroupDataSourceImpl @Inject constructor(
    private val api: CreateGroupAPI
): CreateGroupDataSource {
    override suspend fun createGroup(body: CreateGroupRequest): Flow<CreateGroupResponse> = flow {
        emit(
            ForestApiHandler<CreateGroupResponse>()
                .httpRequest { api.createGroup(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}