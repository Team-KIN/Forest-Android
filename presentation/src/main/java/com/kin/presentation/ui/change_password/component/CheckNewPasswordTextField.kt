package com.kin.presentation.ui.change_password.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CheckNewPasswordTextField() {

    var text by remember {mutableStateOf("")}

    Box(
        modifier = Modifier
            .width(320.dp)
    ) {
        Column() {
            Text(
                text = stringResource(R.string.check_new_password_text),
                color = LightColor.SECONDARY,
                fontSize = 14.sp
            )

            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors()
            )

            Text(
                text = stringResource(R.string.not_match_password),
                color = LightColor.ERROR,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(0.dp, 12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckNewPasswordTextFieldPreview() {
    CheckNewPasswordTextField()
}