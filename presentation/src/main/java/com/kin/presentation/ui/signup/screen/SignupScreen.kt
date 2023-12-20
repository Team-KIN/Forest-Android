package com.kin.presentation.ui.signup.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.domain.model.signup.request.SignupRequestModel
import com.kin.presentation.ui.component.back_page.BackPage
import com.kin.presentation.ui.signup.component.EmailTextField
import com.kin.presentation.ui.signup.component.NicknameTextField
import com.kin.presentation.ui.signup.component.PasswordCheckTextField
import com.kin.presentation.ui.signup.component.PasswordTextFeild
import com.kin.presentation.ui.signup.component.PhoneNumberTextFiled
import com.kin.presentation.ui.signup.component.SignupButton
import com.kin.presentation.ui.signup.component.SignupTitle
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.viewmodel.EmailViewModel
import com.kin.presentation.viewmodel.SignupViewModel
import com.kin.presentation.viewmodel.util.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SignupScreen(
    context: Context,
    lifecycleScope: CoroutineScope,
    viewModel: EmailViewModel,
    signupViewModel: SignupViewModel,
    onSignupButtonClick: (body: SignupRequestModel) -> Unit,
    onBackPageClick: () -> Unit
) {
    var isClick by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    val errorText = remember { mutableStateOf("") }
    val progressState = remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var newPw by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var profileUrl by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ) {
        Column {
            Row(
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Spacer(modifier = Modifier.width(12.dp))
                BackPage()
            }
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                SignupTitle()
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(35.dp))
                EmailTextField(isError = isError,
                    placeHolder = "Email",
                    readOnlyBoolean = false,
                    setTextChageText = email,
                    onFocusChange = { isTextFieldFocused ->
                        isClick = isTextFieldFocused
                    },
                    onValueChange = { text ->
                        email = text
                    })
                Spacer(modifier = Modifier.height(2.dp))
                PhoneNumberTextFiled(isError = isError,
                    placeholder = "PhoneNumber",
                    readOnly = false,
                    setChangeText = phoneNumber,
                    onFocusChange = { isTextFieldFocused ->
                        isClick = isTextFieldFocused
                    },
                    onValueChange = { text ->
                        phoneNumber = text
                    })
                Spacer(modifier = Modifier.height(2.dp))
                NicknameTextField(isError = isError,
                    placeHolder = "Name",
                    readOnly = false,
                    setChangeText = name,
                    onFocusChange = { isTextFieldFocused ->
                        isClick = isTextFieldFocused
                    },
                    onValueChange = { text ->
                        name = text
                    })
                Spacer(modifier = Modifier.height(34.dp))
                PasswordTextFeild(isError = isError,
                    placeHolder = "New Password",
                    readOnly = false,
                    setChangeText = pw,
                    onFocusChange = { isTextFieldFocused ->
                        isClick = isTextFieldFocused
                    },
                    onValueChange = { text ->
                        pw = text
                    })
                Spacer(modifier = Modifier.height(34.dp))
                PasswordCheckTextField(isError = isError,
                    placeHolder = "Password",
                    readOnly = false,
                    setChangeText = newPw,
                    onFocusChange = { isTextFieldFocused ->
                        isClick = isTextFieldFocused
                    },
                    onValueChange = { text ->
                        newPw = text
                    })
                Spacer(modifier = Modifier.height(46.dp))
                SignupButton {
                    if (email.isNotEmpty() && pw.isNotEmpty() && name.isNotEmpty() && newPw.isNotEmpty() && phoneNumber.isNotEmpty()) {
                        isError = false
                        viewModel.sendPhoneNumber(phoneNumber)
                        signupViewModel.registerIdData(
                            email = email,
                            password = pw,
                            name = name,
                            phoneNumber = phoneNumber
                        )
                    } else {
                        isError = true
                        Log.e("failures", "회원가입 실패")
                    }
                }
            }
        }
    }
}

suspend fun signup(
    viewModel: SignupViewModel,
    errorText: (errorText: String) -> Unit,
    progressState: (progressState: Boolean) -> Unit
) {
    viewModel.signupResponse.collect {
        when (it) {
            is Event.Loading -> {
                progressState(true)
            }

            is Event.Success -> {
                progressState(false)
            }

            is Event.BadRequest -> {
                errorText("다시 입력해주세요")
                progressState(false)
            }

            is Event.Conflict -> {
                errorText("중복된 이메일입니다.")
                progressState(false)
            }

            else -> {
                errorText("알수 없는 오류가 발생하였습니다.")
                progressState(false)
            }
        }
    }
}

@Preview
@Composable
fun SignupScreenPreview() {
    // SignupScreen()
}