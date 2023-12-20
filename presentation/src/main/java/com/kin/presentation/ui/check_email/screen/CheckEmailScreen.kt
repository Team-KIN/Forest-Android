package com.kin.presentation.ui.check_email.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.kin.presentation.ui.check_email.component.CheckEmailButton
import com.kin.presentation.ui.check_email.component.CheckEmailTextField
import com.kin.presentation.ui.check_email.component.CheckEmailTitle
import com.kin.presentation.ui.component.back_page.BackPage
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.viewmodel.EmailViewModel
import com.kin.presentation.viewmodel.SignupViewModel
import com.kin.presentation.viewmodel.util.Event
import kotlinx.coroutines.CoroutineScope
import okhttp3.internal.http.hasBody

@Composable
fun CheckEmailScreen(
    context: Context,
    lifecycleScope: CoroutineScope,
    viewModel: EmailViewModel,
    signupViewModel: SignupViewModel,
    onEmailCheckButtonClick: (path: String) -> Unit,
    onBackPageClick: () -> Unit
) {
    var isClick by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    val errorText = remember { mutableStateOf("") }
    val progressState = remember { mutableStateOf(false) }
    var code by remember { mutableStateOf("") }

    val email = signupViewModel.emailData.value
    val password = signupViewModel.passwordData.value
    val name = signupViewModel.nameData.value
    val phoneNumber = signupViewModel.phoneNumber.value

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
                CheckEmailTitle()
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(155.dp))
                CheckEmailTextField(
                    isError = isError,
                    placeHolder = "code",
                    setTextChangeText = code,
                    onFocusChange = { isTextFieldFocused ->
                        isClick = isTextFieldFocused
                    }
                ) { text ->
                    code = text
                }
                Spacer(modifier = Modifier.height(80.dp))
                CheckEmailButton {
                    if (code != null) {
                        isError = false
                        signupViewModel.phoneNumber.value?.let {
                            viewModel.checkCode(
                                code = code.toInt(),
                                phoneNumber = it
                            )
                            if (viewModel.successResponse.value == true) {
                                if (email != null && password != null && name != null && phoneNumber != null) {
                                    val body = SignupRequestModel(
                                        email = email,
                                        password = password,
                                        name = name,
                                        phoneNumber = phoneNumber,
                                        profileUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkor.pngtree.com%2Fso%2F%25ED%2594%2584%25EB%25A1%259C%25ED%2595%2584-%25EC%2582%25AC%25EC%25A7%2584&psig=AOvVaw3JCRX0RYhJCKgcUQMAgeNV&ust=1703136886436000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNj13LqlnYMDFQAAAAAdAAAAABAE"
                                    )
                                    signupViewModel.signup(body = body)
                                }
                            }
                        }
                    } else {
                        isError = true
                        Log.e("failures", "인증번호를 입력해주세요")
                    }

                }
            }
        }
    }

}

suspend fun checkCode(
    viewModel: EmailViewModel,
    errorText: (errorText: String) -> Unit,
    progressState: (progressState: Boolean) -> Unit
) {
    viewModel.checkCodeResponse.collect {
        when (it) {
            is Event.Loading -> {
                progressState(true)
            }

            is Event.Success -> {
                progressState(false)
            }

            is Event.NotFound -> {
                errorText("유요하지 않은 이메일 입니다.")
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
fun CheckEmailScreenPreview() {
    // CheckEmailScreen()
}