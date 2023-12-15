package com.kin.presentation.ui.join_private_group.screen

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
import com.kin.presentation.ui.join_private_group.component.InsertCodeTextField
import com.kin.presentation.ui.join_private_group.component.JoinButton
import com.kin.presentation.ui.join_private_group.component.JoinPrivateGroupTitle
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun JoinPrivateGroupScreen() {
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
            JoinPrivateGroupTitle()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            InsertCodeTextField()
            Spacer(modifier = Modifier.height(306.dp))
            JoinButton{}
        }
    }
}

@Preview
@Composable
fun JoinPrivateGroupScreenPreview() {
    JoinPrivateGroupScreen()
}