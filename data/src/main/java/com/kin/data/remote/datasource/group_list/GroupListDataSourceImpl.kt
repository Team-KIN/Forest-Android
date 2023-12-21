package com.kin.data.remote.datasource.group_list

import com.kin.data.remote.api.group_list.GroupListAPI
import com.kin.data.remote.dto.group_list.response.GroupListResponse
import com.kin.data.util.ForestApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GroupListDataSourceImpl @Inject constructor(
    private val api: GroupListAPI
): GroupListDataSource {
    override suspend fun getGroupList(): Flow<GroupListResponse> = flow {
        emit(
            ForestApiHandler<GroupListResponse>()
                .httpRequest { api.getGroupList() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}