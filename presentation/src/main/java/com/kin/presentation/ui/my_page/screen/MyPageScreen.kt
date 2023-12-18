package com.kin.presentation.ui.my_page.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.my_page.component.LogoutButton
import com.kin.presentation.ui.my_page.component.ProfileImage
import com.kin.presentation.ui.my_page.component.ProfileInfo
import com.kin.presentation.ui.my_page.component.WithdrawalButton
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun MyPageScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ) {
        Column(
            modifier = Modifier.padding(start = 156.dp, top = 68.dp),
        ) {
            ProfileImage()
        }
        Column(
            modifier = Modifier.padding(start = 119.dp, top = 136.dp)
        ) {
            ProfileInfo()
        }
        Column (
            modifier = Modifier.padding(start = 20.dp, top = 218.dp)
        ){
            LogoutButton {}
            Spacer(modifier = Modifier.height(24.dp))
            WithdrawalButton {}
        }
    }
}

@Preview
@Composable
fun MyPageScreenPreview() {
    MyPageScreen()
}