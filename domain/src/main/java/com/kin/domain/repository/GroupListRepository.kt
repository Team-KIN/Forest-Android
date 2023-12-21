package com.kin.domain.repository

import com.kin.domain.model.group_list.response.GroupListResponseModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Header

interface GroupListRepository {
    suspend fun getGroupList(): Flow<GroupListResponseModel>
}