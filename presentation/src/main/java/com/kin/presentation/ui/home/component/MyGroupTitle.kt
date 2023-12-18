package com.kin.presentation.ui.home.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R

@Composable
fun MyGroupTitle() {
    Text(
        text = stringResource(id = R.string.home_title_text),
        fontSize = 18.sp,
        fontWeight = FontWeight(700),
        color = LightColor.BLACK
    )
}

@Preview
@Composable
fun MyGroupTitlePreview() {
    MyGroupTitle()
}