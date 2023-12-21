package com.kin.presentation.ui.signup

import android.content.Intent
import com.kin.presentation.viewmodel.util.Event
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.login.LoginActivity
import com.kin.presentation.ui.signup.screen.SignupScreen
import com.kin.presentation.viewmodel.SignupViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpActivity : BaseActivity() {
    private val signupViewModel by viewModels<SignupViewModel>()
    override fun init() {
        observeEvent()
        setContent {
            SignupScreen(
                context = this,
                lifecycleScope = lifecycleScope,
                viewModel = viewModel(LocalContext.current as SignUpActivity),
                onSignupButtonClick = {

                },
                onBackPageClick = {
                    backPage()
                }
            )
        }
    }

    private fun observeEvent() {
        lifecycleScope.launch {
            signupViewModel.signupResponse.collect {
                if (it is Event.Success) {
                    backPage()
                    finish()
                }
            }
        }
    }

    private fun backPage() {
        startActivity(
            Intent(
                this,
                LoginActivity::class.java
            )
        )
    }
}