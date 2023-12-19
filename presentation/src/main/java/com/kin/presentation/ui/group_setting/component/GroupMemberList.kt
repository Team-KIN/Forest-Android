package com.kin.presentation.ui.group_setting.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.group_setting.item.GroupMemberItem

@Composable
fun GroupMemberList() {
    Box(){
        LazyColumn{
            items(count = 50){
                Spacer(modifier = Modifier.width(8.dp))
                GroupMemberItem()
            }
        }
    }
}

@Preview
@Composable
fun GroupMemberListPreview(){
    GroupMemberList()
}