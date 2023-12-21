package com.kin.presentation.ui.login.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    isError: Boolean = false,
    placeHolder: String,
    readOnly: Boolean = false,
    setChangeText: String,
    singleLine: Boolean = true,
    onFocusChange: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit = {}
) {

    var text by remember { mutableStateOf("") }
    text = setChangeText

    Box(modifier = Modifier.width(320.dp)) {
        Column() {
            Column() {
                Text(
                    text = stringResource(R.string.password_text),
                    color = LightColor.SECONDARY,
                    fontSize = 14.sp
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                        onValueChange(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(),
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        color = LightColor.BLACK
                    )
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
//                Text(
//                    text = stringResource(R.string.not_password),
//                    color = LightColor.ERROR,
//                    fontSize = 12.sp,
//                    modifier = Modifier
//                        .padding(0.dp, 12.dp)
//                )

                Spacer(modifier = Modifier.width(245.dp))
                Text(
                    text = stringResource(R.string.search_password),
                    color = LightColor.FOCUS,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(0.dp, 12.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PasswordTextFieldPreview() {
    // PasswordTextField()
}