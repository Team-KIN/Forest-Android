package com.kin.data.remote.dto.login.response

import com.kin.domain.model.login.response.LoginResponseModel

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: String,
    val refreshTokenExpiredAt: String
)

fun LoginResponse.toLogInModel() =
    LoginResponseModel(
        accessToken = this.accessToken,
        refreshToken = this.refreshToken,
        accessTokenExpiredAt = this.accessTokenExpiredAt,
        refreshTokenExpiredAt = this.refreshTokenExpiredAt
    )