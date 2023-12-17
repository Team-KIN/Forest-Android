package com.kin.presentation.ui.new_group_description.screen

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
import com.kin.presentation.ui.new_group_description.component.CreateGroupButton
import com.kin.presentation.ui.new_group_description.component.DescriptionTextField
import com.kin.presentation.ui.new_group_description.component.GroupDescriptionTitle
import com.kin.presentation.ui.new_group_description.component.LatterNum
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun NewGroupDescriptionScreen() {
    Column(modifier= Modifier
        .fillMaxSize()
        .background(LightColor.WHITE)
    ) {
        Row(modifier = Modifier.padding(top = 18.dp)) {
            Spacer(modifier = Modifier.width(12.dp))
            BackPage()
        }
        Column(modifier = Modifier.padding(start = 20.dp)) {
            Spacer(modifier = Modifier.height(23.dp))
            GroupDescriptionTitle()
            Spacer(modifier = Modifier.height(4.dp))
            DescriptionTextField()
        }
        Column(modifier = Modifier.padding(start = 310.dp)) {
            Spacer(modifier = Modifier.height(60.dp))
            LatterNum()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            CreateGroupButton {}
        }
    }
}

@Preview
@Composable
fun NewGroupDescriptionScreenPreview() {
    NewGroupDescriptionScreen()
}