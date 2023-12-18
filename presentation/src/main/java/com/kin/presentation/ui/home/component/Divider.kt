package com.kin.presentation.ui.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun Divider(){
    Column (
        modifier = Modifier
            .width(328.dp)
            .height(1.00003.dp)
            .border(
                width = 100.dp,
                color = LightColor.GRAY2
            ),
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start
    ){

    }
}

@Preview
@Composable
fun DividerPreview(){
    Divider()
}