package com.kin.domain.model.login.response

data class LoginResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: String,
    val refreshTokenExpiredAt: String
)