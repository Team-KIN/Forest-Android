package com.kin.domain.repository

import com.kin.domain.model.main.response.MainModel
import kotlinx.coroutines.flow.Flow


interface MainRepository {
    suspend fun main(): Flow<MainModel>
}