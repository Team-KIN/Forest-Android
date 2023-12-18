package com.kin.presentation.ui.group_todo.component.private_todo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.theme.color.LightColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPrivateTodoTextField() {
    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier.width(320.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = LightColor.TRANSPARENCY,
                unfocusedIndicatorColor = LightColor.PRIVATETODO
            )
        )
    }
}

@Preview
@Composable
fun AddPrivateTodoTextFieldPreview() {
    AddPrivateTodoTextField()
}