package com.kin.domain.usecase.group_list

import com.kin.domain.repository.GroupListRepository
import javax.inject.Inject

class GetGroupListUseCase @Inject constructor(
    private val groupListRepository: GroupListRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        groupListRepository.getGroupList()
    }
}