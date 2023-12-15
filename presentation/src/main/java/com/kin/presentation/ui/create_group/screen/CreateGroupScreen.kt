package com.kin.presentation.ui.create_group.screen

import androidx.compose.foundation.background
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
import com.kin.presentation.ui.create_group.component.CreateGroupTitle
import com.kin.presentation.ui.create_group.component.GroupNameTextField
import com.kin.presentation.ui.create_group.component.GroupStatus
import com.kin.presentation.ui.create_group.component.GroupTargetTextField
import com.kin.presentation.ui.create_group.component.NextPageButton
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun CreateGroupScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ) {
        Row(
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            BackPage()
        }
        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(23.dp))
            CreateGroupTitle()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            GroupNameTextField()
            Spacer(modifier = Modifier.height(30.dp))
            GroupTargetTextField()
            Spacer(modifier = Modifier.height(16.dp))
            GroupStatus()
            Spacer(modifier = Modifier.height(208.dp))
            NextPageButton {}
        }
    }
}

@Preview
@Composable
fun CreateGroupScreenPreview() {
    CreateGroupScreen()
}