package com.kin.forest_android.module

import com.kin.data.local.datasource.login.LocalLoginDataSource
import com.kin.data.local.datasource.login.LocalLoginDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    abstract fun provideLocalLoginDataSource(
        localLoginDataSourceImpl: LocalLoginDataSourceImpl
    ): LocalLoginDataSource
}