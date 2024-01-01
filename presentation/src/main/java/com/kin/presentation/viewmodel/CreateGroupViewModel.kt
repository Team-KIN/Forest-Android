package com.kin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.model.create_group.request.CreateGroupRequestModel
import com.kin.domain.model.create_group.response.CreateGroupResponseModel
import com.kin.domain.usecase.create_group.CreateGroupUseCase
import com.kin.presentation.viewmodel.util.Event
import com.kin.presentation.viewmodel.util.errorHandling
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateGroupViewModel @Inject constructor(
    private val createGroupUseCase: CreateGroupUseCase
): ViewModel() {
    private val _createGroupResponse = MutableStateFlow<Event<CreateGroupResponseModel>>(Event.Loading)
    val createGroupResponse = _createGroupResponse.asStateFlow()

    fun createGroup(body: CreateGroupRequestModel) = viewModelScope.launch {
        createGroupUseCase (
            body = body
        ).onSuccess {
            it.catch { remoteError ->
                _createGroupResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _createGroupResponse.value = Event.Success(data = response)
            }
        }.onFailure {
            _createGroupResponse.value = it.errorHandling()
        }
    }
}