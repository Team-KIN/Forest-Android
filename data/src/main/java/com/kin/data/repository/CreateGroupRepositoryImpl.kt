package com.kin.data.repository

import com.kin.data.remote.datasource.create_group.CreateGroupDataSource
import com.kin.data.remote.dto.create_group.request.CreateGroupRequest
import com.kin.data.remote.dto.create_group.response.toCreateGroupModel
import com.kin.domain.model.create_group.request.CreateGroupRequestModel
import com.kin.domain.model.create_group.response.CreateGroupResponseModel
import com.kin.domain.repository.CreateGroupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CreateGroupRepositoryImpl @Inject constructor(
    private val createGroupDataSource: CreateGroupDataSource
): CreateGroupRepository {
    override suspend fun createGroup(body: CreateGroupRequestModel): Flow<CreateGroupResponseModel> {
        return createGroupDataSource.createGroup(
            body = CreateGroupRequest(
                name = body.name,
                content = body.content,
                purpose = body.purpose
            )
        ).map { it.toCreateGroupModel() }
    }
}