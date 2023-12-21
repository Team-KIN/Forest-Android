package com.kin.data.repository

import com.kin.data.remote.datasource.group_list.GroupListDataSource
import com.kin.data.remote.dto.group_list.response.toGroupListModel
import com.kin.domain.model.group_list.response.GroupListResponseModel
import com.kin.domain.repository.GroupListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GroupListRepositoryImpl @Inject constructor(
    private val groupListDataSource: GroupListDataSource
): GroupListRepository {
    override suspend fun getGroupList(): Flow<GroupListResponseModel> {
        return groupListDataSource.getGroupList().map { it.toGroupListModel() }
    }
}