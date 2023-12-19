package com.kin.presentation.ui.group_management.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.R
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun DropoutDialog(
    onClick: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            confirmButton = {
                TextButton(onClick = { onClick }) {
                    Text(
                        text = stringResource(id = R.string.dropout),
                        color = LightColor.ERROR
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = { onClick }) {
                    Text(
                        text = stringResource(id = R.string.cancel_text),
                        color = LightColor.FOCUS
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(id = R.string.dropout_check_text),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = LightColor.BLACK
                )
            },
            text = {
                Text(
                    text = stringResource(id = R.string.check_dropout_text),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(500),
                    color = LightColor.BLACK
                )
            },
            modifier = Modifier
                .background(
                    color = LightColor.WHITE,
                    shape = RoundedCornerShape(16.dp)
                )
        )
    }
}

@Preview
@Composable
fun DropoutDialogPreview() {
    DropoutDialog() {}
}