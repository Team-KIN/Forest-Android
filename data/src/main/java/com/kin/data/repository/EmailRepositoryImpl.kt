package com.kin.data.repository

import com.kin.data.remote.datasource.email.SendPhoneNumberDataSource
import com.kin.domain.repository.EmailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val sendPhoneNumberDataSource: SendPhoneNumberDataSource
) : EmailRepository {
    override suspend fun sendPhoneNumber(path: String): Flow<Unit> {
        return sendPhoneNumberDataSource.sendPhoneNumber(
            path = path
        )
    }

    override suspend fun checkCode(code: Int, phoneNumber: String): Flow<Unit> {
        return sendPhoneNumberDataSource.checkCode(
            code = code,
            phoneNumber = phoneNumber
        )
    }

}