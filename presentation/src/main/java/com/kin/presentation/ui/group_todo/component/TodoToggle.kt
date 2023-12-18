package com.kin.presentation.ui.group_todo.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamgrapefruit.presentation.R

@Composable
fun TodoToggle() {
    Box(modifier = Modifier.size(96.dp, 26.dp)) {
        Image(
            painter = painterResource(R.drawable.todo_toggle),
            contentDescription = "Todo Toggle")
    }
}

@Preview
@Composable
fun TodoTogglePreview() {
    TodoToggle()
}