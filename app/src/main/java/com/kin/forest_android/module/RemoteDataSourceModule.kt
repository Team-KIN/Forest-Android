package com.kin.forest_android.module

import com.kin.data.remote.datasource.login.LoginDataSource
import com.kin.data.remote.datasource.login.LoginDateSourceImpl
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
}