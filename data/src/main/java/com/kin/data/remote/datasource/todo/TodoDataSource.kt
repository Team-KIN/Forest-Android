package com.kin.data.remote.datasource.todo

import com.kin.data.remote.dto.todo.request.TodoRequest
import com.kin.data.remote.dto.todo.response.TodoResponse
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface TodoDataSource {

    suspend fun todo(path: TodoRequest): Flow<TodoResponse>
}