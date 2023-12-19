package com.kin.domain.usecase.login

import com.kin.domain.model.login.response.LoginResponseModel
import com.kin.domain.repository.LoginRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(token: LoginResponseModel) = kotlin.runCatching {
        loginRepository.saveToken(token = token)
    }
}