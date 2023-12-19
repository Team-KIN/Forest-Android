package com.kin.presentation.ui.group_management.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.group_management.item.GroupMemberItem
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupMemberList() {
    Box {
        LazyColumn {
            items(count = 9) {
                GroupMemberItem {}
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
        Spacer(
            modifier = Modifier
                .width(320.dp)
                .height(70.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            LightColor.WHITE
                        )
                    )
                )
        )
    }
}

@Preview
@Composable
fun GroupMemberListPreview() {
    GroupMemberList()
}