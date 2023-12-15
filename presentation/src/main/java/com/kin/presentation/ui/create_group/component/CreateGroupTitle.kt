package com.kin.presentation.ui.create_group.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R

@Composable
fun CreateGroupTitle() {
    Text(
        text = stringResource(R.string.create_group_text),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = LightColor.BLACK
    )
}

@Preview
@Composable
fun CreateGroupTitlePreview() {
    CreateGroupTitle()
}