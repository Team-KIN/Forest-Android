package com.kin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.model.signup.request.SignupRequestModel
import com.kin.presentation.viewmodel.util.Event
import com.kin.domain.usecase.signup.SignupUseCase
import com.kin.presentation.viewmodel.util.errorHandling
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase
): ViewModel() {
    private val _signupResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val signupResponse = _signupResponse.asStateFlow()

    fun signup(body: SignupRequestModel) = viewModelScope.launch {
        signupUseCase (
            body = body
        ).onSuccess {
            it.catch { remoteError ->
                _signupResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _signupResponse.value = Event.Success(data = response)
            }
        }.onFailure {
            _signupResponse.value = it.errorHandling()
        }
    }
}