package com.kin.data.repository

import com.kin.data.remote.datasource.main.MainDataSource
import com.kin.domain.model.main.response.MainModel
import com.kin.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
): MainRepository{
    override suspend fun main(): Flow<MainModel> {
        return mainDataSource.main()
    }

}