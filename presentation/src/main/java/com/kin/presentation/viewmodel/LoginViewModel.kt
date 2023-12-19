package com.kin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.model.login.request.LoginRequestModel
import com.kin.domain.model.login.response.LoginResponseModel
import com.kin.domain.usecase.login.DeleteTokenUseCase
import com.kin.domain.usecase.login.GetAccessTokenUseCase
import com.kin.domain.usecase.login.LoginUseCase
import com.kin.domain.usecase.login.LogoutUseCase
import com.kin.domain.usecase.login.SaveTokenUseCase
import com.kin.presentation.viewmodel.util.Event
import com.kin.presentation.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
): ViewModel() {
    private val _loginResponse = MutableStateFlow<Event<LoginResponseModel>>(Event.Loading)
    val loginResponse = _loginResponse.asStateFlow()

    private val _saveTokenResponse = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val saveTokenResponse = _saveTokenResponse.asStateFlow()

    private val _getAccessTokenResponse = MutableStateFlow<Event<String>>(Event.Loading)
    val getAccessTokenResponse = _getAccessTokenResponse.asStateFlow()

    private val _logoutResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val logoutResponse = _logoutResponse.asStateFlow()

    fun login(body: LoginRequestModel) = viewModelScope.launch {
        loginUseCase (
            body = body
        ).onSuccess {
            it.catch {remoteError ->
                _loginResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _loginResponse.value = Event.Success(data = response)
            }
        }.onFailure {
            _loginResponse.value  = it.errorHandling()
        }
    }

    fun getAccessToken() = viewModelScope.launch {
        getAccessTokenUseCase ()
            .onSuccess {
                it.catch { remoteError ->
                    _getAccessTokenResponse.value = remoteError.errorHandling()
                }.collect { response ->
                    _getAccessTokenResponse.value = Event.Success(data = response)
                }
            }.onFailure {
                _getAccessTokenResponse.value = it.errorHandling()
            }
    }

    fun saveToken(token: LoginResponseModel) = viewModelScope.launch {
        saveTokenUseCase (
            token = token
        ).onSuccess {
            _saveTokenResponse.value = Event.Success()
        }.onFailure {
            _saveTokenResponse.value = it.errorHandling()
        }
    }

    fun logout() = viewModelScope.launch {
        logoutUseCase()
            .onSuccess {
                it.catch {remoteError ->
                    _logoutResponse.value = remoteError.errorHandling()
                }.collect { response ->
                    _logoutResponse.value = Event.Success(data = response)
                    deleteTokenUseCase()
                }
            }.onFailure {
                _logoutResponse.value = it.errorHandling()
            }
    }
}