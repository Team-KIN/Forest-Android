package com.kin.domain.model.todo.response

import java.util.UUID

data class TodoResponseModel(
    val publicTodos: List<PublicTodoModel>,
    val privateTodos: List<PrivateTodoModel>
)

data class PublicTodoModel(
    val id: UUID,
    val content: String,
    val achievementRate: Int,
    val todoStatus: Boolean
)

data class PrivateTodoModel(
    val id: UUID,
    val content: String,
    val todoStatus: Boolean
)