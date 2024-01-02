package com.kin.data.remote.api.main

import com.kin.domain.model.main.response.MainModel
import retrofit2.http.GET

interface MainAPI {

    @GET("/main")
    suspend fun main(): MainModel
}