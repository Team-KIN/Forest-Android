package com.kin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.model.todo.request.TodoRequestModel
import com.kin.domain.model.todo.response.TodoResponseModel
import com.kin.domain.usecase.todo.TodoUseCase
import com.kin.presentation.viewmodel.util.Event
import com.kin.presentation.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCase: TodoUseCase
): ViewModel() {
    private val _todoResponse = MutableStateFlow<Event<TodoResponseModel>>(Event.Loading)
    val todoResponse = _todoResponse.asStateFlow()

    fun todo(path: TodoRequestModel) = viewModelScope.launch {
        todoUseCase (
            path = path
        ).onSuccess {
            it.catch { remoteError ->
                _todoResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _todoResponse.value = Event.Success(data = response)
            }
        }.onFailure {
            _todoResponse.value = it.errorHandling()
        }
    }
}