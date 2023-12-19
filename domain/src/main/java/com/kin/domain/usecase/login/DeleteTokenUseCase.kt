package com.kin.domain.usecase.login

import com.kin.domain.repository.LoginRepository
import javax.inject.Inject

class DeleteTokenUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){
    suspend operator fun invoke() {
        loginRepository.deleteToken()
    }
}