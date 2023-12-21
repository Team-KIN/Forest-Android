package com.kin.presentation.ui.login

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.group_list.GroupListActivity
import com.kin.presentation.ui.home.MainActivity
import com.kin.presentation.ui.login.screen.LoginScreen
import com.kin.presentation.ui.signup.SignUpActivity
import com.kin.presentation.viewmodel.LoginViewModel
import com.kin.presentation.viewmodel.util.Event
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity: BaseActivity() {
    private val loginViewModel by viewModels<LoginViewModel>()

    private lateinit var token: String
    override fun init() {
        lifecycleScope.launch {
            loginViewModel.saveTokenResponse.collect {
                if (it is Event.Success) {
                    pageHome()
                    finish()
                }
            }
        }
        setContent {
            LoginScreen(
                context = this,
                lifecycleScope = lifecycleScope,
                viewModel = viewModel(LocalContext.current as LoginActivity),
                onSignUpClick = {
                    pageSignUp()
                    finish()
                },
                onMainClick = {
                    pageHome()
                    finish()
                }
            )
        }
    }

    private fun pageSignUp() {
        startActivity(
            Intent(
                this,
                SignUpActivity::class.java
            )
        )
    }

    private fun pageHome() {
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )
    }
}