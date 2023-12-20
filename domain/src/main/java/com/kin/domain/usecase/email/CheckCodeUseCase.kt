package com.kin.domain.usecase.email

import com.kin.domain.repository.EmailRepository
import javax.inject.Inject

class CheckCodeUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {

    suspend operator fun invoke(code: Int, phoneNumber: String) = kotlin.runCatching {
        emailRepository.checkCode(code = code, phoneNumber = phoneNumber)
    }
}