package com.kin.presentation.ui.group_setting.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupExplainTextField(text: String) {
    var text = text

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth(),
        readOnly = false,
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            color = LightColor.BLACK
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = LightColor.WHITE,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Preview
@Composable
fun GroupExplainTextFieldPreview() {
    GroupExplainTextField(
        "이 나무는 모시깽이하는 나무인데\n" +
                "과연 이놈이 침엽수인지 활엽수인지\n" +
                "저로서는 도저히 알 수가 없는 그러한 그런\n" +
                "모시깽이한 모시깽이라고 할 수 있습니다"
    )
}