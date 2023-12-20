package com.kin.data.remote.datasource.email

import kotlinx.coroutines.flow.Flow


interface SendPhoneNumberDataSource {
    suspend fun sendPhoneNumber(path: String): Flow<Unit>

    suspend fun checkCode(code: Int, phoneNumber: String): Flow<Unit>
}