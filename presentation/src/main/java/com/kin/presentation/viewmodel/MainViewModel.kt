package com.kin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.usecase.main.MainUseCase
import com.kin.presentation.viewmodel.util.Event
import com.kin.presentation.viewmodel.util.errorHandling
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
): ViewModel(){
    private val _mainResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val mainResponse = _mainResponse.asStateFlow()

    fun main() = viewModelScope.launch {
        mainUseCase().onSuccess {
            it.catch { remoteError ->
                _mainResponse.value = remoteError.errorHandling()
            }.collect {
                _mainResponse.value = Event.Success(data = null)
            }
        }.onFailure {
            _mainResponse.value = it.errorHandling()
        }
    }
}