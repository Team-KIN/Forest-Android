package com.kin.data.remote.datasource.todo

import com.kin.data.remote.api.todo.TodoAPI
import com.kin.data.remote.dto.todo.request.TodoRequest
import com.kin.data.remote.dto.todo.response.TodoResponse
import com.kin.data.util.ForestApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.UUID
import javax.inject.Inject

class TodoDataSourceImpl @Inject constructor(
    private val api: TodoAPI
): TodoDataSource {
    override suspend fun todo(path: TodoRequest): Flow<TodoResponse> = flow {
        emit(
            ForestApiHandler<TodoResponse>()
                .httpRequest { api.todo(id = path.id) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}