package com.kin.presentation.ui.group_management.screen

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
import com.kin.presentation.ui.group_management.component.AllSelectButton
import com.kin.presentation.ui.group_management.component.DropoutButton
import com.kin.presentation.ui.group_management.component.GroupManagementTitle
import com.kin.presentation.ui.group_management.component.GroupMemberList
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupManagementScreen(
    onClick: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(LightColor.WHITE)
    ) {
        Column {
            Spacer(modifier = Modifier.height(11.dp))
            BackPage(
                onClick = onClick
            )
            Spacer(modifier = Modifier.height(27.dp))
            Row {
                Spacer(modifier = Modifier.width(20.dp))
                GroupManagementTitle()
                Spacer(modifier = Modifier.width(120.dp))
                AllSelectButton()
            }
            Spacer(modifier = Modifier.height(26.dp))
            Column (
                modifier = Modifier.padding(start = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                GroupMemberList()
                DropoutButton {}
            }
        }
    }
}

@Preview
@Composable
fun GroupManagementScreenPreview() {
    // GroupManagementScreen()
}