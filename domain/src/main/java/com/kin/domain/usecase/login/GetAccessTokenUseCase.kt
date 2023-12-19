package com.kin.domain.usecase.login

import com.kin.domain.repository.LoginRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        loginRepository.getAccessToken()
    }
}