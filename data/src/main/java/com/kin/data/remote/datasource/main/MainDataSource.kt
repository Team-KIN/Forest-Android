package com.kin.data.remote.datasource.main

import com.kin.domain.model.main.response.MainModel
import kotlinx.coroutines.flow.Flow

interface MainDataSource {

    suspend fun main(): Flow<MainModel>
}