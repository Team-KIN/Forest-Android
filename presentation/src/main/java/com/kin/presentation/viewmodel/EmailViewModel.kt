package com.kin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.usecase.email.CheckCodeUseCase
import com.kin.domain.usecase.email.SendPhoneNumberUseCase
import com.kin.presentation.viewmodel.util.Event
import com.kin.presentation.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmailViewModel @Inject constructor(
    private val sendPhoneNumberUseCase: SendPhoneNumberUseCase,
    private val checkCodeUseCase: CheckCodeUseCase
): ViewModel(){
    private val _sendPhoneNumberResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val sendPhoneNumberResponse = _sendPhoneNumberResponse.asStateFlow()

    private val _checkCodeResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val checkCodeResponse = _checkCodeResponse.asStateFlow()

    private val _successResponse = MutableLiveData<Boolean>(false)
    val successResponse: LiveData<Boolean> get() = _successResponse

    fun sendPhoneNumber(path: String) = viewModelScope.launch {
        sendPhoneNumberUseCase(
            path = path
        ).onSuccess {
            it.catch { remoteError ->
                _sendPhoneNumberResponse.value = remoteError.errorHandling()
            }.collect {response ->
                _sendPhoneNumberResponse.value = Event.Success(data = response)
            }
        }.onFailure {
            _sendPhoneNumberResponse.value = it.errorHandling()
        }
    }

    fun checkCode(code: Int, phoneNumber: String) = viewModelScope.launch {
        checkCodeUseCase(
            code = code,
            phoneNumber = phoneNumber
        ).onSuccess {
            it.catch { remoteError ->
                _checkCodeResponse.value = remoteError.errorHandling()
            }.collect{ response ->
                _checkCodeResponse.value = Event.Success(data = response)
                _successResponse.value = true
            }
        }.onFailure {
            _checkCodeResponse.value =it.errorHandling()
        }
    }

}