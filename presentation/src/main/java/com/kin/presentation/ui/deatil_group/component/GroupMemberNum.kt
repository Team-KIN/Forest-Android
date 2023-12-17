package com.kin.presentation.ui.deatil_group.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupMemberNum() {
    Text(
        text = "1024명이 이 나무를 함께 키웁니다.",
        fontSize = 18.sp,
        color = LightColor.GRAY2,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun GroupMemberNumPreview() {
    GroupMemberNum()
}