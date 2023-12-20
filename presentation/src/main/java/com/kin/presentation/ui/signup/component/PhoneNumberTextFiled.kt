package com.kin.presentation.ui.signup.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.R
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun PhoneNumberTextFiled(
    isError: Boolean = false,
    placeholder: String,
    readOnly: Boolean = false,
    setChangeText: String,
    singleLine: Boolean = true,
    onFocusChange: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    text = setChangeText

    Box(modifier = Modifier.width(320.dp)) {
        Column {
            Text(
                text = stringResource(R.string.phone_number_text),
                color = LightColor.SECONDARY,
                fontSize = 14.sp
            )

            TextField(
                value = text,
                onValueChange = {
                    text = it
                    onValueChange(it)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors()
            )
        }
    }
}

@Preview
@Composable
fun PhoneNumberTextFiledPreview() {
    // PhoneNumberTextFiled()
}