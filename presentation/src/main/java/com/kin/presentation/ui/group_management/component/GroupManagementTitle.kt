package com.kin.presentation.ui.group_management.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun GroupManagementTitle(){
    Text(
        text = stringResource(id = R.string.group_management_text),
        fontSize = 18.sp,
        fontWeight = FontWeight(700),
        color = LightColor.BLACK
    )
}

@Preview
@Composable
fun GroupManagementTitlePreview(){
    GroupManagementTitle()
}