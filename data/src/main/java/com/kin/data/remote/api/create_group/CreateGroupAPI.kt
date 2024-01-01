package com.kin.data.remote.api.create_group

import com.kin.data.remote.dto.create_group.request.CreateGroupRequest
import com.kin.data.remote.dto.create_group.response.CreateGroupResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateGroupAPI {
    @POST("group")
    suspend fun createGroup(
        @Body body: CreateGroupRequest
    ): CreateGroupResponse
}