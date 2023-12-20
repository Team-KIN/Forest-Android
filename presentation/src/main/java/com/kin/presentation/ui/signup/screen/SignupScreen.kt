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
import com.kin.presentation.viewmodel.SignupViewModel
import com.kin.presentation.viewmodel.util.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SignupScreen(
    context: Context,
    lifecycleScope: CoroutineScope,
    viewModel: SignupViewModel,
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

    val body = SignupRequestModel(
        email = email,
        password = pw,
        name = name,
        phoneNumber = phoneNumber,
        profileUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkor.pngtree.com%2Fso%2F%25ED%2594%2584%25EB%25A1%259C%25ED%2595%2584-%25EC%2582%25AC%25EC%25A7%2584&psig=AOvVaw3JCRX0RYhJCKgcUQMAgeNV&ust=1703136886436000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNj13LqlnYMDFQAAAAAdAAAAABAE"
    )

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
                        viewModel.signup(body)
                        lifecycleScope.launch {
                            signup(
                                viewModel = viewModel,
                                errorText = { text ->
                                    errorText.value = text
                                },
                                progressState = { state ->
                                    progressState.value = state
                                }
                            )
                        }
                        onSignupButtonClick(body)
                        Log.d("success", "회원가입 성공")
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