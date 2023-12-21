package com.kin.presentation.ui.deatil_group.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.component.back_page.BackPage
import com.kin.presentation.ui.deatil_group.component.GroupDescription
import com.kin.presentation.ui.deatil_group.component.GroupMemberNum
import com.kin.presentation.ui.deatil_group.component.GroupNameTitle
import com.kin.presentation.ui.deatil_group.component.GroupTarget
import com.kin.presentation.ui.deatil_group.component.JoinGroupButton
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun DetailGroupScreen(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ) {
        Column() {
            Row(
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Spacer(modifier = Modifier.width(12.dp))
                BackPage(
                    onClick = onClick
                )
            }
            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(23.dp))
                GroupNameTitle()
                Spacer(modifier = Modifier.height(36.dp))
                GroupTarget()
                Spacer(modifier = Modifier.height(28.dp))
                GroupDescription()
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(128.dp))
                GroupMemberNum()
                Spacer(modifier = Modifier.height(16.dp))
                JoinGroupButton {}
            }
        }
    }
}

@Preview
@Composable
fun DetailGroupScreenPreview() {
    // DetailGroupScreen()
}