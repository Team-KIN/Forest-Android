package com.kin.data.util

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.kin.data.local.datasource.login.LocalLoginDataSource
import com.kin.domain.exception.TokenExpirationException
import com.kin.data.BuildConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import javax.inject.Inject

class Interceptor @Inject constructor(
    private val dataSource: LocalLoginDataSource,
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val currentTime = System.currentTimeMillis().toForestTimeDate()
        val ignorePath = listOf("/auth")
        val ignoreMethod = listOf("POST")
        val groupPath = listOf("/group")
        val groupMethod = listOf("GET")
        val path = request.url.encodedPath
        val method = request.method

        ignorePath.forEachIndexed { index, s ->
            if (path.startsWith(s) && ignoreMethod[index] == method) {
                return chain.proceed(request)
            }
        }
        groupPath.forEachIndexed { index, s ->
            if(s == path && groupMethod[index] == method) {
                return chain.proceed(request)
            }
        }

        runBlocking {
            val refreshTime = dataSource.getRefreshTime().first().replace("\"", "")
            val accessTime = dataSource.getAccessTime().first().replace("\"", "")

            if (refreshTime == "") {
                return@runBlocking
            }

            if (currentTime.after(refreshTime.toDate())) {
                throw TokenExpirationException()
            }

            // access token 재발급
            if (currentTime.after(accessTime.toDate())) {
                val client = OkHttpClient()
                val refreshToken = dataSource.getRefreshToken().first().replace("\"", "")
                val refreshTokenWithBearer = "Bearer $refreshToken"
                val refreshRequest = Request.Builder()
                    .url("${BuildConfig.BASE_URL}/auth")
                    .patch(chain.request().body ?: RequestBody.create(null, byteArrayOf()))
                    .addHeader(
                        "Refresh-Token",
                        refreshTokenWithBearer
                    )
                    .build()
                val jsonParser = JsonParser()
                val response = client.newCall(refreshRequest).execute()
                if (response.isSuccessful) {
                    val token = jsonParser.parse(response.body!!.string()) as JsonObject
                    dataSource.setAccessToken(token["accessToken"].toString())
                    dataSource.setRefreshToken(token["refreshToken"].toString())
                    dataSource.setAccessTime(token["accessExp"].toString())
                    dataSource.setRefreshTime(token["refreshExp"].toString())
                } else throw TokenExpirationException()
            }

            val accessToken = dataSource.getAccessToken().first().replace("\"", "")
            builder.addHeader("Authorization", "Bearer $accessToken")
        }
        return chain.proceed(builder.build())
    }
}