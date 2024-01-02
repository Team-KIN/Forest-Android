package com.kin.data.remote.dto.todo.response

import com.google.gson.annotations.SerializedName
import com.kin.data.remote.dto.todo.request.TodoRequest
import com.kin.domain.model.todo.response.PrivateTodoModel
import com.kin.domain.model.todo.response.PublicTodoModel
import com.kin.domain.model.todo.response.TodoResponseModel
import java.util.UUID

data class TodoResponse(
    @SerializedName("publicTodos")
    val publicTodos: List<PublicTodo>,
    @SerializedName("privateTodos")
    val privateTodos: List<PrivateTodo>
)

data class PublicTodo(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("content")
    val content: String,
    @SerializedName("achievementRate")
    val achievementRate: Int,
    @SerializedName("todoStatus")
    val todoStatus: Boolean
)

data class PrivateTodo(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("content")
    val content: String,
    @SerializedName("todoStatus")
    val todoStatus: Boolean
)

fun TodoResponse.toTodoModel() =
    TodoResponseModel(
        publicTodos = this.publicTodos.map { it.toTodoModel() },
        privateTodos = this.privateTodos.map { it.toTodoModel() }
    )

fun PublicTodo.toTodoModel() =
    PublicTodoModel(
        id = this.id,
        content = this.content,
        achievementRate = this.achievementRate,
        todoStatus = this.todoStatus
    )

fun PrivateTodo.toTodoModel() =
    PrivateTodoModel(
        id = this.id,
        content = this.content,
        todoStatus = this.todoStatus
    )