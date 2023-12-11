package com.kin.presentation.ui.group_list.screen

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
import com.kin.presentation.ui.group_list.component.GroupList
import com.kin.presentation.ui.group_list.component.GroupListTitle
import com.kin.presentation.ui.group_list.component.OptionButton
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightColor.WHITE)
    ) {
        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            GroupListTitle()
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.width(344.dp),
            contentAlignment = Alignment.Center
        ) {
            GroupList()
        }
    }
    Column(modifier = Modifier.padding(start = 320.dp)) {
        Spacer(modifier = Modifier.height(572.dp))
        OptionButton {}
    }
}

@Preview
@Composable
fun GroupListScreenPreview() {
    GroupListScreen()
}