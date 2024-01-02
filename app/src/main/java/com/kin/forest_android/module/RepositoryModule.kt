package com.kin.forest_android.module

import com.kin.data.repository.CreateGroupRepositoryImpl
import com.kin.data.repository.GroupListRepositoryImpl
import com.kin.data.repository.LoginRepositoryImpl
import com.kin.data.repository.SignupRepositoryImpl
import com.kin.data.repository.TodoRepositoryImpl
import com.kin.domain.repository.CreateGroupRepository
import com.kin.domain.repository.GroupListRepository
import com.kin.domain.repository.LoginRepository
import com.kin.domain.repository.SignupRepository
import com.kin.domain.repository.TodoRepository
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

    @Binds
    abstract fun provideGroupListRepository(
        groupListRepositoryImpl: GroupListRepositoryImpl
    ): GroupListRepository

    @Binds
    abstract fun provideCreateGroupRepository(
        createGroupListRepositoryImpl: CreateGroupRepositoryImpl
    ): CreateGroupRepository

    @Binds
    abstract fun provideTodoRepository(
        todoRepositoryImpl: TodoRepositoryImpl
    ): TodoRepository
}