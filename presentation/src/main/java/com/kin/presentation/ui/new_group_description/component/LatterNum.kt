package com.kin.presentation.ui.new_group_description.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun LatterNum() {

        Text(
            text = "82/200",
            fontSize = 12.sp,
            color = LightColor.GRAY,
            modifier = Modifier.padding(end = 28.dp)
        )

}

@Preview
@Composable
fun LatterNumPreview() {
    LatterNum()
}