package com.kin.domain.usecase.todo

import com.kin.domain.model.todo.request.TodoRequestModel
import com.kin.domain.repository.TodoRepository
import javax.inject.Inject

class TodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(path: TodoRequestModel) = kotlin.runCatching {
        todoRepository.todo(path = path)
    }
}