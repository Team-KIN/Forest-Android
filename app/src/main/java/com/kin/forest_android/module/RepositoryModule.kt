package com.kin.forest_android.module

import com.kin.data.repository.LoginRepositoryImpl
import com.kin.data.repository.SignupRepositoryImpl
import com.kin.domain.repository.LoginRepository
import com.kin.domain.repository.SignupRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository

    @Binds
    abstract fun provideSignupRepository(
        signupRepositoryImpl: SignupRepositoryImpl
    ): SignupRepository
}