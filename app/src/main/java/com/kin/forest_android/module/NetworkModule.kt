package com.kin.forest_android.module

import com.kin.data.remote.api.login.LoginAPI
import com.kin.data.util.Interceptor
import com.kin.data.BuildConfig
import com.kin.data.remote.api.group_list.GroupListAPI
import com.kin.data.remote.api.signup.SignupAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkhttpClient(
    interceptor: Interceptor,
    ): OkHttpClient
    {
        return OkHttpClient.Builder()
            .cookieJar(CookieJar.NO_COOKIES)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun loginService(retrofit: Retrofit): LoginAPI {
        return retrofit.create(LoginAPI::class.java)
    }

    @Provides
    @Singleton
    fun groupListService(retrofit: Retrofit): GroupListAPI {
        return retrofit.create(GroupListAPI::class.java)
    }


    @Provides
    @Singleton
    fun signupService(retrofit: Retrofit): SignupAPI {
        return retrofit.create(SignupAPI::class.java)

    }

    @Provides
    @Singleton
    fun groupListService(retrofit: Retrofit): GroupListAPI {
        return retrofit.create(GroupListAPI::class.java)
    }
}