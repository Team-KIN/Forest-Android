package com.kin.data.repository

import com.kin.data.remote.datasource.signup.SignupDataSource
import com.kin.data.remote.dto.signup.request.SignupRequest
import com.kin.domain.model.signup.request.SignupRequestModel
import com.kin.domain.repository.SignupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignupRepositoryImpl @Inject constructor(
    private val signupDataSource: SignupDataSource
): SignupRepository{
    override suspend fun signup(body: SignupRequestModel): Flow<Unit> {
        return signupDataSource.signup(
            body = SignupRequest(
                email = body.email,
                password = body.password,
                name = body.name,
                phoneNumber = body.phoneNumber,
                profileUrl = body.profileUrl
            )
        )
    }
}