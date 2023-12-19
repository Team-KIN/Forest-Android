package com.kin.data.repository

import com.kin.data.local.datasource.login.LocalLoginDataSource
import com.kin.data.remote.datasource.login.LoginDataSource
import com.kin.data.remote.dto.login.request.LoginRequest
import com.kin.data.remote.dto.login.response.toLogInModel
import com.kin.domain.model.login.request.LoginRequestModel
import com.kin.domain.model.login.response.LoginResponseModel
import com.kin.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val localLoginDataSource: LocalLoginDataSource,
    private val remoteLoginDataSource: LoginDataSource
): LoginRepository {
    override suspend fun authLogIn(body: LoginRequestModel): Flow<LoginResponseModel> {
        return remoteLoginDataSource.login(
            body = LoginRequest(
                email = body.email,
                password = body.password
            )
        ).map { it.toLogInModel() }
    }

    override suspend fun saveToken(token: LoginResponseModel) {
        token.let {
            localLoginDataSource.setAccessToken(it.accessToken)
            localLoginDataSource.setAccessTime(it.accessTokenExpiredAt)
            localLoginDataSource.setRefreshToken(it.refreshToken)
            localLoginDataSource.setRefreshTime(it.refreshTokenExpiredAt)
        }
    }

    override suspend fun getAccessToken(): Flow<String> {
        return localLoginDataSource.getAccessToken()
    }

    override suspend fun logout(): Flow<Unit> {
        return remoteLoginDataSource.logout()
    }

    override suspend fun deleteToken() {
        localLoginDataSource.removeAccessToken()
        localLoginDataSource.removeRefreshToken()
        localLoginDataSource.removeAccessTime()
        localLoginDataSource.removeRefreshTime()
    }
}