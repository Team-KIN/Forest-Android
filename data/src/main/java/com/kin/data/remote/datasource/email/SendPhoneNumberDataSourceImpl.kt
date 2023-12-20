package com.kin.data.remote.datasource.email

import com.kin.data.remote.api.email.EmailAPI
import com.kin.data.util.ForestApiHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SendPhoneNumberDataSourceImpl @Inject constructor(
    private val api: EmailAPI
) :SendPhoneNumberDataSource{
    override suspend fun sendPhoneNumber(path: String): Flow<Unit> = flow{
        emit(
            ForestApiHandler<Unit>()
                .httpRequest { api.sendPhoneNumber(phoneNumber = path) }
                .sendRequest()
        )
    }

    override suspend fun checkCode(code: Int, phoneNumber: String): Flow<Unit> = flow{
        emit(
            ForestApiHandler<Unit>()
                .httpRequest { api.checkCode(authCode = code, phoneNumber = phoneNumber) }
                .sendRequest()
        )
    }
}