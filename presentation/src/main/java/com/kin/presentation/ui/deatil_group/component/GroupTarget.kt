package com.kin.presentation.ui.deatil_group.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R

@Composable
fun GroupTarget() {
    Box(modifier = Modifier.width(320.dp)) {
        Column() {
            Text(
                text = stringResource(R.string.group_target_text),
                color = LightColor.SECONDARY,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "공부하려고",
                color = LightColor.BLACK,
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun GroupTargetPreview() {
    GroupTarget()
}