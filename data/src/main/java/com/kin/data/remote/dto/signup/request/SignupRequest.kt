package com.kin.data.remote.dto.signup.request

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password" )
    val password: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("profileUrl")
    val profileUrl: String
)
