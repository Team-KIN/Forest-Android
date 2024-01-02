package com.kin.domain.model.main.response

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class MainModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("profile_url")
    val profileUrl: String,
    @SerializedName("groups")
    val groups: List<Groups>
) {
    data class Groups(
        @SerializedName("id")
        val id: UUID,
        @SerializedName("name")
        val name: String,
        @SerializedName("headcount")
        val headCount: Int,
        @SerializedName("todo")
        val todo: Int
    )

    fun Groups.toEntity() = MainModel.Groups(
        id = id,
        name = name,
        headCount = headCount,
        todo = todo
    )
}