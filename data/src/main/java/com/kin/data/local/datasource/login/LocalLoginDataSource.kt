package com.kin.data.local.datasource.login

import kotlinx.coroutines.flow.Flow

interface LocalLoginDataSource {

    suspend fun getAccessToken(): Flow<String>

    suspend fun setAccessToken(accessToken: String)

    suspend fun removeAccessToken()

    suspend fun getAccessTime(): Flow<String>

    suspend fun setAccessTime(accessTime: String)

    suspend fun removeAccessTime()

    suspend fun getRefreshToken(): Flow<String>

    suspend fun setRefreshToken(refreshToken: String)

    suspend fun removeRefreshToken()

    suspend fun getRefreshTime(): Flow<String>

    suspend fun setRefreshTime(refreshTime: String)

    suspend fun removeRefreshTime()
}