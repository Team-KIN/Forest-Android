package com.kin.presentation.ui.check_email.component

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
fun CheckEmailTitle(){
    Box {
        Text(
            text = stringResource(R.string.check_email),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = LightColor.BLACK
        )
    }

}

@Preview
@Composable
fun CheckEmailTitlePreview(){
    CheckEmailTitle()
}