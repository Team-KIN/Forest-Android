package com.kin.data.remote.dto.main.response

import com.google.gson.annotations.SerializedName
import com.kin.domain.model.main.response.MainModel as DomainMainModel
import com.kin.domain.model.main.response.MainModel.Groups as DomainGroups
import java.util.UUID

data class MainModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("profile_url")
    val profileUrl: String,
    @SerializedName("groups")
    val groups: Groups
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

    fun Groups.toEntity() = DomainMainModel.Groups(
        id = id,
        name = name,
        headCount = headCount,
        todo = todo
    )
}

fun MainModel.toEntity() = DomainMainModel(
    name = name,
    email = email,
    profileUrl = profileUrl,
    groups = DomainGroups(
        id = groups.id,
        name = groups.name,
        headCount = groups.headCount,
        todo = groups.todo
    )
)
