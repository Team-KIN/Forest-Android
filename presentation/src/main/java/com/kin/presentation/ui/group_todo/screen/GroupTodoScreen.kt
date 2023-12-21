package com.kin.presentation.ui.group_todo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.component.back_page.BackPage
import com.kin.presentation.ui.group_todo.component.GroupName
import com.kin.presentation.ui.group_todo.component.TodoToggle
import com.kin.presentation.ui.group_todo.component.group_todo.GroupTodoCheck
import com.kin.presentation.ui.group_todo.component.group_todo.GroupTodoTitle
import com.kin.presentation.ui.group_todo.component.private_todo.PrivateTodoCheck
import com.kin.presentation.ui.group_todo.component.private_todo.PrivateTodoTitle
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupTodoScreen(
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .width(358.dp)
                    .padding(top = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackPage(
                    onClick = onClick
                )
                TodoToggle()
            }
        }
        Column(modifier = Modifier.padding(start = 20.dp)) {
            Spacer(modifier = Modifier.height(23.dp))
            GroupName()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            GroupTodoTitle {}
            Spacer(modifier = Modifier.height(20.dp))
            GroupTodoCheck()
            Spacer(modifier = Modifier.height(16.dp))
            PrivateTodoTitle {}
            Spacer(modifier = Modifier.height(20.dp))
            PrivateTodoCheck()
        }
    }
}

@Preview
@Composable
fun GroupTodoScreenPreview() {
    // GroupTodoScreen()
}