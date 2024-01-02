package com.kin.presentation.ui.login.screen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.domain.model.login.request.LoginRequestModel
import com.kin.presentation.ui.login.component.EmailTextField
import com.kin.presentation.ui.login.component.LoginButton
import com.kin.presentation.ui.login.component.OrSignUp
import com.kin.presentation.ui.login.component.PasswordTextField
import com.kin.presentation.ui.login.component.Title
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.viewmodel.LoginViewModel
import com.kin.presentation.viewmodel.util.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoginScreen(
    context: Context,
    lifecycleScope: CoroutineScope,
    viewModel: LoginViewModel,
    onSignUpClick: () -> Unit,
    onMainClick: () -> Unit
) {
    var isClick by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    val errorText = remember { mutableStateOf("") }
    val progressState = remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    val body = LoginRequestModel(
        email = email,
        password = pw
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            Title()
            Spacer(modifier = Modifier.height(48.dp))
            EmailTextField(
                isError = isError,
                placeHolder = "Email",
                readOnly = false,
                setChangeText = email,
                onFocusChange = { isTextFieldFocused ->
                    isClick = isTextFieldFocused
                },
                onValueChange = { text ->
                    email = text
                }
            )
            Spacer(modifier = Modifier.height(38.dp))
            PasswordTextField(
                isError = isError,
                placeHolder = "Password",
                readOnly = false,
                setChangeText = pw,
                onFocusChange = { isTextFieldFocused ->
                    isClick = isTextFieldFocused
                },
                onValueChange = { text ->
                    pw = text
                }
            )
            Spacer(modifier = Modifier.height(34.dp))
            LoginButton {
                if (email.isNotEmpty() && pw.isNotEmpty()) {
                    isError = false
                    viewModel.login(body)
                    lifecycleScope.launch {
                        login(
                            viewModel = viewModel,
                            errorText = { text ->
                                errorText.value = text
                            },
                            progressState = { state ->
                                progressState.value = state
                            },
                            onMainClick = { onMainClick() }
                        )
                    }
                    Toast.makeText(context, "로그인 성공", Toast.LENGTH_SHORT).show()
                    Log.d("success", "로그인 성공")
                } else {
                    isError = true
                    Toast.makeText(context, "로그인 실패", Toast.LENGTH_SHORT).show()
                    Log.d("failures", "로그인 실패")
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            OrSignUp {
                onSignUpClick()
            }
        }
    }
}

suspend fun login(
    viewModel: LoginViewModel,
    errorText: (errorText: String) -> Unit,
    progressState: (progressState: Boolean) -> Unit,
    onMainClick: () -> Unit
) {
    viewModel.loginResponse.collect {
        when (it) {
            is Event.Loading -> {
                progressState(true)
            }

            is Event.Success -> {
                viewModel.saveToken(token = it.data!!)
                viewModel.getAccessToken()
                onMainClick()
                progressState(false)
            }

            is Event.BadRequest -> {
                errorText("비밀번호가 일치하지 않습니다.")
                progressState(false)
            }

            is Event.NotFound -> {
                errorText("존재하지 않은 이메일입니다.")
                progressState(false)
            }

            else -> {
                errorText("알 수 없는 에러가 발생했습니다.")
                progressState(false)
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    // LoginScreen(LocalContext.current, false, "",{}, {})
}