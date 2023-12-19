package com.kin.presentation.ui.new_group_description.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun DescriptionTextField() {
    var text by remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier.size(243.dp, 534.dp),
        contentAlignment = Alignment.TopStart
    ) {
        if (text.text.isEmpty()) {
            Text(
                text = stringResource(R.string.insert_description),
                fontSize = 16.sp,
                color = LightColor.GRAY
            )
        }
        TextField(
            value = text,
            onValueChange = { "Group Description" },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = LightColor.TRANSPARENCY,
                unfocusedIndicatorColor = LightColor.TRANSPARENCY
            ),
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = LightColor.BLACK
            )
        )
    }
}

@Preview
@Composable
fun DescriptionTextFieldPreview() {
    DescriptionTextField()
}