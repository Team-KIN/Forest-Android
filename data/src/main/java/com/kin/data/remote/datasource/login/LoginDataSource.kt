package com.kin.data.remote.datasource.login

import com.kin.data.remote.dto.login.request.LoginRequest
import com.kin.data.remote.dto.login.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginDataSource {

    suspend fun login(body: LoginRequest): Flow<LoginResponse>

    suspend fun logout(): Flow<Unit>
}