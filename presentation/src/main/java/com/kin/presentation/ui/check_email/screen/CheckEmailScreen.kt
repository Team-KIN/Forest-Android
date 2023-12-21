package com.kin.presentation.ui.check_email.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.check_email.component.CheckEmailButton
import com.kin.presentation.ui.check_email.component.CheckEmailTextField
import com.kin.presentation.ui.check_email.component.CheckEmailTitle
import com.kin.presentation.ui.component.back_page.BackPage
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun CheckEmailScreen(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ){
        Column {
            Row(
                modifier = Modifier.padding(top = 18.dp)
            ){
                Spacer(modifier = Modifier.width(12.dp))
                BackPage(
                    onClick = onClick
                )
            }
            Column (
                modifier = Modifier.padding(20.dp)
            ){
                CheckEmailTitle()
            }
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(155.dp))
                CheckEmailTextField()
                Spacer(modifier = Modifier.height(80.dp))
                CheckEmailButton {}
            }
        }
    }

}

@Preview
@Composable
fun CheckEmailScreenPreview() {
    // CheckEmailScreen()
}