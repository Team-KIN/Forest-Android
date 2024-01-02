package com.kin.domain.usecase.create_group

import com.kin.domain.model.create_group.request.CreateGroupRequestModel
import com.kin.domain.repository.CreateGroupRepository
import javax.inject.Inject

class CreateGroupUseCase @Inject constructor(
    private val createGroupRepository: CreateGroupRepository
) {
    suspend operator fun invoke(body: CreateGroupRequestModel) = kotlin.runCatching {
        createGroupRepository.createGroup(body = body)
    }
}