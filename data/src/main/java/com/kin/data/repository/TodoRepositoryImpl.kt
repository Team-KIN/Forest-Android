package com.kin.data.repository

import com.kin.data.remote.datasource.todo.TodoDataSource
import com.kin.data.remote.dto.todo.request.TodoRequest
import com.kin.data.remote.dto.todo.response.toTodoModel
import com.kin.domain.model.todo.request.TodoRequestModel
import com.kin.domain.model.todo.response.TodoResponseModel
import com.kin.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDataSource: TodoDataSource
): TodoRepository {
    override suspend fun todo(path: TodoRequestModel): Flow<TodoResponseModel> {
        return todoDataSource.todo(
            path = TodoRequest(
                id = path.id
            )
        ).map { it.toTodoModel() }
    }
}