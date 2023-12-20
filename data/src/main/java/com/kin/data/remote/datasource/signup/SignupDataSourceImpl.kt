package com.kin.data.remote.datasource.signup

import com.kin.data.remote.api.signup.SignupAPI
import com.kin.data.remote.dto.signup.request.SignupRequest
import com.kin.data.util.ForestApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SignupDataSourceImpl @Inject constructor(
    private val api: SignupAPI
) : SignupDataSource {
    override suspend fun signup(body: SignupRequest): Flow<Unit> = flow {
        emit(
            ForestApiHandler<Unit>()
                .httpRequest { api.signup(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}