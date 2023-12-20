package com.kin.data.remote.api.signup

import com.kin.data.remote.dto.signup.request.SignupRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupAPI {
    @POST
    suspend fun signup(
        @Body body: SignupRequest
    ): Response<Unit>
}