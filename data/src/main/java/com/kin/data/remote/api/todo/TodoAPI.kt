package com.kin.data.remote.api.todo

import com.kin.data.remote.dto.todo.response.TodoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface TodoAPI {
    @GET("group/{id}/todo-list")
    suspend fun todo(
        @Path("id") id: UUID
    ): TodoResponse
}