package com.kin.presentation.ui.group_list.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kin.presentation.R

@Composable
fun GroupPageDialog() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            text = {
                Image(
                    painter = painterResource(id = R.drawable.group_list_dialog),
                    contentDescription = "Group List Dialog",
                    modifier = Modifier.fillMaxSize()
                )
            },
            confirmButton = {},
            dismissButton = {}
        )
    }
}

@Preview
@Composable
fun GroupPageDialogPreview() {
    GroupPageDialog()
}