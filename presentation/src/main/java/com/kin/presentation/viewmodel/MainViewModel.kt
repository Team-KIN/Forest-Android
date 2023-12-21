package com.kin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.model.main.response.MainModel
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
    private val _mainResponse = MutableStateFlow<Event<MainModel>>(Event.Loading)
    val mainResponse = _mainResponse.asStateFlow()

    private val _mainData = MutableLiveData<MainModel>()
    val mainData: LiveData<MainModel> get() = _mainData
    fun main() = viewModelScope.launch {
        mainUseCase().onSuccess {
            it.catch { remoteError ->
                _mainResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _mainResponse.value = Event.Success(data = response)
                _mainData.value = response
            }
        }.onFailure {
            _mainResponse.value = it.errorHandling()
        }
    }
}