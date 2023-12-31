package com.kin.forest_android.module

import com.kin.data.remote.datasource.create_group.CreateGroupDataSource
import com.kin.data.remote.datasource.create_group.CreateGroupDataSourceImpl
import com.kin.data.remote.datasource.group_list.GroupListDataSource
import com.kin.data.remote.datasource.group_list.GroupListDataSourceImpl
import com.kin.data.remote.datasource.login.LoginDataSource
import com.kin.data.remote.datasource.login.LoginDateSourceImpl
import com.kin.data.remote.datasource.main.MainDataSource
import com.kin.data.remote.datasource.main.MainDataSourceImpl
import com.kin.data.remote.datasource.signup.SignupDataSource
import com.kin.data.remote.datasource.signup.SignupDataSourceImpl
import com.kin.data.remote.datasource.todo.TodoDataSource
import com.kin.data.remote.datasource.todo.TodoDataSourceImpl
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
    abstract fun provideMainDataSource(
        mainDataSourceImpl: MainDataSourceImpl
    ): MainDataSource

    @Binds
    abstract fun provideGroupListDataSource(
        groupListDataSourceImpl: GroupListDataSourceImpl
    ): GroupListDataSource


    @Binds
    abstract fun provideCreateGroupDataSource(
        createGroupDataSourceImpl: CreateGroupDataSourceImpl
    ): CreateGroupDataSource

    @Binds
    abstract fun provideTodoDataSource(
        todoDataSourceImpl: TodoDataSourceImpl
    ): TodoDataSource
}