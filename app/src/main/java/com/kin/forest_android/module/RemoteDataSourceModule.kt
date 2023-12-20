package com.kin.forest_android.module

import com.kin.data.remote.datasource.email.SendPhoneNumberDataSource
import com.kin.data.remote.datasource.email.SendPhoneNumberDataSourceImpl
import com.kin.data.remote.datasource.login.LoginDataSource
import com.kin.data.remote.datasource.login.LoginDateSourceImpl
import com.kin.data.remote.datasource.signup.SignupDataSource
import com.kin.data.remote.datasource.signup.SignupDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun provideLoginDataSource(
        loginDataSourceImpl: LoginDateSourceImpl
    ): LoginDataSource

    @Binds
    abstract fun provideSignupDataSource(
        signupDataSourceImpl: SignupDataSourceImpl
    ): SignupDataSource

    @Binds
    abstract fun provideSendPhoneNumberDataSource(
        sendPhoneNumberDataSourceImpl: SendPhoneNumberDataSourceImpl
    ): SendPhoneNumberDataSource
}