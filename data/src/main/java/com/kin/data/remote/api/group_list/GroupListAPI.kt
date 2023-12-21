package com.kin.data.remote.api.group_list

import com.kin.data.remote.dto.group_list.response.GroupListResponse
import retrofit2.http.GET

interface GroupListAPI {
    @GET("group")
    suspend fun getGroupList(): GroupListResponse
}