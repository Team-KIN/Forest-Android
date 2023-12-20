package com.kin.domain.usecase.email

import com.kin.domain.repository.EmailRepository
import javax.inject.Inject

class SendPhoneNumberUseCase @Inject constructor(
    private val emailRepository: EmailRepository
){
    suspend operator fun invoke(path: String) = kotlin.runCatching{
        emailRepository.sendPhoneNumber(path = path)
    }

}