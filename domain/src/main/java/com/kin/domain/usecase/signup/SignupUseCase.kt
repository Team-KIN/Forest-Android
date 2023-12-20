package com.kin.domain.usecase.signup

import com.kin.domain.model.signup.request.SignupRequestModel
import com.kin.domain.repository.SignupRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val signupRepository: SignupRepository
){
    suspend operator fun invoke(body: SignupRequestModel) = kotlin.runCatching {
        signupRepository.signup(body = body)
    }
}