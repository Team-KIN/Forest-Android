package com.kin.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kin.domain.model.group_list.response.GroupListModel
import com.kin.domain.model.group_list.response.GroupListResponseModel
import com.kin.domain.model.login.response.LoginResponseModel
import com.kin.domain.usecase.group_list.GetGroupListUseCase
import com.kin.domain.usecase.login.GetAccessTokenUseCase
import com.kin.presentation.viewmodel.util.Event
import com.kin.presentation.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupListViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
    private val getGroupListUseCase: GetGroupListUseCase
): ViewModel() {
    private val _getGroupListResponse = MutableStateFlow<Event<GroupListResponseModel>>(Event.Loading)
    val getGroupListResponse = _getGroupListResponse.asStateFlow()

    private val _getAccessTokenResponse = MutableStateFlow<Event<String>>(Event.Loading)
    val getAccessTokenResponse = _getAccessTokenResponse.asStateFlow()

    var groupList = mutableStateListOf<GroupListModel>()
    fun getGroupList() = viewModelScope.launch {
        getGroupListUseCase()
            .onSuccess {
                it.catch { remoteError ->
                    _getGroupListResponse.value = remoteError.errorHandling()
                }.collect { response ->
                    _getGroupListResponse.value = Event.Success(data = response)
                }
            }.onFailure {
                _getGroupListResponse.value = it.errorHandling()
            }
    }

    fun getAccessToken() = viewModelScope.launch {
        getAccessTokenUseCase()
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
}