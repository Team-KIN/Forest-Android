package com.kin.domain.repository

import com.kin.domain.model.todo.request.TodoRequestModel
import com.kin.domain.model.todo.response.TodoResponseModel
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface TodoRepository {

    suspend fun todo(path: TodoRequestModel): Flow<TodoResponseModel>
}