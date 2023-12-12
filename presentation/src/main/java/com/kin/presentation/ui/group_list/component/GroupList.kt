package com.kin.presentation.ui.group_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.group_list.item.GroupItemList

@Composable
fun GroupList() {
    Box(
    ) {
        LazyColumn {
            items(50){
                GroupItemList()
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun GroupListPreview() {
    GroupList()
}