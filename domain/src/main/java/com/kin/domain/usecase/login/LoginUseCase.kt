package com.kin.domain.usecase.login

import com.kin.domain.model.login.request.LoginRequestModel
import com.kin.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(body: LoginRequestModel) = kotlin.runCatching {
        loginRepository.authLogIn(body = body)
    }
}