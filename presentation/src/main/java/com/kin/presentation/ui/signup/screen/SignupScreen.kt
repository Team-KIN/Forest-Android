package com.kin.presentation.ui.signup.screen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.component.back_page.BackPage
import com.kin.presentation.ui.signup.component.EmailTextField
import com.kin.presentation.ui.signup.component.NicknameTextField
import com.kin.presentation.ui.signup.component.PasswordCheckTextField
import com.kin.presentation.ui.signup.component.PasswordTextFeild
import com.kin.presentation.ui.signup.component.PhoneNumberTextFiled
import com.kin.presentation.ui.signup.component.SignupButton
import com.kin.presentation.ui.signup.component.SignupTitle
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun SignupScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ){
        Column {
            Row(
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Spacer(modifier = Modifier.width(12.dp))
                BackPage()
            }
            Column (
                modifier = Modifier.padding(20.dp)
            ){
                SignupTitle()
            }
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(35.dp))
                EmailTextField()
                Spacer(modifier = Modifier.height(2.dp))
                PhoneNumberTextFiled()
                Spacer(modifier = Modifier.height(2.dp))
                NicknameTextField()
                Spacer(modifier = Modifier.height(34.dp))
                PasswordTextFeild()
                Spacer(modifier = Modifier.height(34.dp))
                PasswordCheckTextField()
                Spacer(modifier = Modifier.height(46.dp))
                SignupButton {}
            }
        }
    }
}

@Preview
@Composable
fun SignupScreenPreview(){
    SignupScreen()
}