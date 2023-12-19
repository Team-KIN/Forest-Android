package com.kin.presentation.ui.signup

import androidx.activity.compose.setContent
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.signup.screen.SignupScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity: BaseActivity() {
    override fun init() {
        setContent {
            SignupScreen()
        }
    }
}