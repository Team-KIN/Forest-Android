package com.kin.data.remote.datasource.signup

import com.kin.data.remote.dto.signup.request.SignupRequest
import kotlinx.coroutines.flow.Flow

interface SignupDataSource {
    suspend fun signup(body: SignupRequest): Flow<Unit>
}