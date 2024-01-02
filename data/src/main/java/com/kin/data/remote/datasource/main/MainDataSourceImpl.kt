package com.kin.data.remote.datasource.main

import com.kin.data.remote.api.main.MainAPI
import com.kin.domain.model.main.response.MainModel
import com.kin.data.util.ForestApiHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val api: MainAPI
): MainDataSource{
    override suspend fun main(): Flow<MainModel> = flow{
        emit(
            ForestApiHandler<MainModel>()
                .httpRequest { api.main() }
                .sendRequest()
        )
    }

}