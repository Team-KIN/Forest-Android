package com.kin.domain.repository

import com.kin.domain.model.login.request.LoginRequestModel
import com.kin.domain.model.login.response.LoginResponseModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun authLogIn(body: LoginRequestModel): Flow<LoginResponseModel>

    suspend fun saveToken(token: LoginResponseModel)

    suspend fun getAccessToken(): Flow<String>

    suspend fun logout(): Flow<Unit>

    suspend fun deleteToken()
}