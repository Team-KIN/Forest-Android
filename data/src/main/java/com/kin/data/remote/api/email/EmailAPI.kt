package com.kin.data.remote.api.email

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmailAPI {

    @POST("/email/send/phone-number/{phone_number}")
    suspend fun sendPhoneNumber(
        @Path("phone_number") phoneNumber: String
    )

    @GET("/auth-code/{authCode}/phone-number/{phoneNumber}")
    suspend fun checkCode(
        @Path("authCode") authCode: Int,
        @Path("phone_number") phoneNumber: String
    )
}