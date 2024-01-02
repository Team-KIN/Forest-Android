package com.kin.data.remote.api.login

import com.kin.data.remote.dto.login.request.LoginRequest
import com.kin.data.remote.dto.login.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface LoginAPI {
    @POST("/auth/signin")
    suspend fun login(
        @Body body: LoginRequest
    ): LoginResponse

    @DELETE("/auth/logout")
    suspend fun logout(): Response<Unit>
}