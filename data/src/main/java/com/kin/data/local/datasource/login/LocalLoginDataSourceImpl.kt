package com.kin.data.local.datasource.login

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.kin.data.local.key.login.LoginPreferenceKey
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalLoginDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : LocalLoginDataSource {
    override suspend fun getAccessToken(): Flow<String> = dataStore.data.map {
        it[LoginPreferenceKey.ACCESS_TOKEN] ?: ""
    }

    override suspend fun setAccessToken(accessToken: String) {
        dataStore.edit {
            it[LoginPreferenceKey.ACCESS_TOKEN] = accessToken
        }
    }

    override suspend fun removeAccessToken() {
        dataStore.edit {
            it.remove(LoginPreferenceKey.ACCESS_TOKEN)
        }
    }

    override suspend fun getAccessTime(): Flow<String> = dataStore.data.map {
        it[LoginPreferenceKey.ACCESS_TIME] ?: ""
    }

    override suspend fun setAccessTime(accessTime: String) {
        dataStore.edit {
            it[LoginPreferenceKey.ACCESS_TIME] = accessTime
        }
    }

    override suspend fun removeAccessTime() {
        dataStore.edit {
            it.remove(LoginPreferenceKey.ACCESS_TIME)
        }
    }

    override suspend fun getRefreshToken(): Flow<String> = dataStore.data.map {
        it[LoginPreferenceKey.REFRESH_TOKEN] ?: ""
    }

    override suspend fun setRefreshToken(refreshToken: String) {
        dataStore.edit {
            it[LoginPreferenceKey.REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun removeRefreshToken() {
        dataStore.edit {
            it.remove(LoginPreferenceKey.REFRESH_TOKEN)
        }
    }

    override suspend fun getRefreshTime(): Flow<String> = dataStore.data.map {
        it[LoginPreferenceKey.REFRESH_TIME] ?: ""
    }

    override suspend fun setRefreshTime(refreshTime: String) {
        dataStore.edit {
            it[LoginPreferenceKey.REFRESH_TIME] = refreshTime
        }
    }

    override suspend fun removeRefreshTime() {
        dataStore.edit {
            it.remove(LoginPreferenceKey.REFRESH_TIME)
        }
    }
}
