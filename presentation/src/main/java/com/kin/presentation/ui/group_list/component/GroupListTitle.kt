package com.kin.presentation.ui.group_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupListTitle() {
    Box() {
        Text(
            text = "숲에 함께하기",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = LightColor.BLACK
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GroupListTitlePreview() {
    GroupListTitle()
}