package com.kin.presentation.ui.deatil_group.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupNameTitle() {
    Text(
        text = "모여봐요 공부의 숲",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = LightColor.BLACK
    )
}

@Preview
@Composable
fun GroupNameTitlePreview() {
    GroupNameTitle()
}