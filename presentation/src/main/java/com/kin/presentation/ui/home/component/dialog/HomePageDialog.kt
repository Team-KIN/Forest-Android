package com.kin.presentation.ui.home.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kin.presentation.R


@Composable
fun HomePageDialog() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            text = {
                Image(
                    painter = painterResource(R.drawable.home_dialog),
                    contentDescription = "Home Dialog",
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
fun HomePageDialogPreview() {
    HomePageDialog()
}