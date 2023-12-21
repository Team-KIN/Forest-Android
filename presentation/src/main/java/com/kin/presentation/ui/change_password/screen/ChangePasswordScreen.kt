package com.kin.presentation.ui.change_password.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.change_password.component.ChangeButton
import com.kin.presentation.ui.change_password.component.ChangePasswordTitle
import com.kin.presentation.ui.change_password.component.CheckNewPasswordTextField
import com.kin.presentation.ui.change_password.component.NewPasswordTextField
import com.kin.presentation.ui.component.back_page.BackPage


@Composable
fun ChangePasswordScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column() {
            Row(
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Spacer(modifier = Modifier.width(12.dp))
                BackPage()
            }
            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(23.dp))
                ChangePasswordTitle()
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(123.dp))
                NewPasswordTextField()
                Spacer(modifier = Modifier.height(38.dp))
                CheckNewPasswordTextField()
                Spacer(modifier = Modifier.height(50.dp))
                ChangeButton {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChangePasswordScreenPreview() {
    ChangePasswordScreen()
}