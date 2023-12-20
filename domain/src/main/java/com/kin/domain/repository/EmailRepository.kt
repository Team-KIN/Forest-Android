package com.kin.domain.repository

import kotlinx.coroutines.flow.Flow
interface EmailRepository {
    suspend fun sendPhoneNumber(path: String): Flow<Unit>
    
    suspend fun checkCode(code: Int, phoneNumber: String): Flow<Unit>
}