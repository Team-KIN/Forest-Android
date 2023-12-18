package com.kin.presentation.ui.group_todo.component.private_todo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.group_todo.component.private_todo.check_item.PrivateCheckItem

@Composable
fun PrivateTodoCheck() {
    Box(modifier = Modifier.size(360.dp, 168.dp)) {
        LazyColumn {
            items(2){
                PrivateCheckItem()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun PrivateTodoCheckPreview() {
    PrivateTodoCheck()
}