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
fun GroupDescription() {
    Column(
        modifier = Modifier.width(320.dp)
    ) {
        Text(
            text = stringResource(R.string.group_description),
            fontSize = 14.sp,
            color = LightColor.SECONDARY
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier.height(334.dp)
        ) {
            Text(
                text = "이 나무는 모시깽이하는 나무인데\n" +
                        "과연 이놈이 침엽수인지 활엽수인지\n" +
                        "저로서는 도저히 알 수가 없는 그러한 그런\n" +
                        "모시깽이한 모시깽이라고 할 수 있습니다",
                fontSize = 15.sp,
                color = LightColor.BLACK
            )
        }
    }
}

@Preview
@Composable
fun GroupDescriptionPreview() {
    GroupDescription()
}