package com.kin.domain.repository

import com.kin.domain.model.signup.request.SignupRequestModel
import kotlinx.coroutines.flow.Flow

interface SignupRepository {
    suspend fun signup(body: SignupRequestModel): Flow<Unit>
}