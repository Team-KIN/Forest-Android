package com.kin.data.remote.datasource.login

import com.kin.data.remote.api.login.LoginAPI
import com.kin.data.remote.dto.login.request.LoginRequest
import com.kin.data.remote.dto.login.response.LoginResponse
import com.kin.data.util.ForestApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
class LoginDateSourceImpl @Inject constructor(
    private val api: LoginAPI
): LoginDataSource {
    override suspend fun login(body: LoginRequest): Flow<LoginResponse> = flow {
        emit(
            ForestApiHandler<LoginResponse>()
                .httpRequest { api.login(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun logout(): Flow<Unit> = flow {
        emit(
            ForestApiHandler<Unit>()
                .httpRequest { api.logout() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}
