package com.kin.presentation.ui.change_password.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun ChangeButton(
    onClick: () -> Unit
) {
    Box() {
        Button(
            modifier = Modifier
                .width(320.dp)
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                LightColor.PRIMARY
            ),
            shape = RoundedCornerShape(16.dp),
            onClick = { onClick() }
        ) {
            Text(
                text = stringResource(R.string.change_text),
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChangeButtonPreview() {
    ChangeButton() {}
}