package com.kin.domain.repository

import com.kin.domain.model.create_group.request.CreateGroupRequestModel
import com.kin.domain.model.create_group.response.CreateGroupResponseModel
import kotlinx.coroutines.flow.Flow

interface CreateGroupRepository {

    suspend fun createGroup(body: CreateGroupRequestModel): Flow<CreateGroupResponseModel>
}