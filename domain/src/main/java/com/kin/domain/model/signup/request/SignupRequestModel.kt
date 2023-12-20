package com.kin.domain.model.signup.request

data class SignupRequestModel(
    val email: String,
    val password: String,
    val name: String,
    val phoneNumber: String,
    val profileUrl: String
)