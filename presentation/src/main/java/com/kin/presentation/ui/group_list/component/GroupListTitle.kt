package com.kin.presentation.ui.group_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R

@Composable
fun GroupListTitle() {
    Box() {
        Text(
            text = stringResource(R.string.join_group_text),
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