package com.kin.presentation.ui.auth.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.auth.component.EmailTextField
import com.kin.presentation.ui.auth.component.LoginButton
import com.kin.presentation.ui.auth.component.OrSignUp
import com.kin.presentation.ui.auth.component.PasswordTextField
import com.kin.presentation.ui.auth.component.Title
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun LoginScreen() {
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
            EmailTextField()
            Spacer(modifier = Modifier.height(38.dp))
            PasswordTextField()
            Spacer(modifier = Modifier.height(34.dp))
            LoginButton {}
            Spacer(modifier = Modifier.height(12.dp))
            OrSignUp()
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}