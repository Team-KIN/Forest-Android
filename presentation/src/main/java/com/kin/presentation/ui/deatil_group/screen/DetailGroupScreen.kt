package com.kin.presentation.ui.deatil_group.screen

import android.content.Context
import android.widget.Toast
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
    context: Context,
    onBack: () -> Unit,
    onMyGroup: () -> Unit
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
                    { onBack() }
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
                JoinGroupButton {
                    onMyGroup()
                    Toast.makeText(context, "그룹에 가입되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailGroupScreenPreview() {
    // DetailGroupScreen()
}