package com.kin.presentation.ui.group_management.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun DropoutButton(
    onclick: () -> Unit
) {
    Button(
        modifier = Modifier
            .width(320.dp)
            .height(52.dp),
        onClick = { onclick },
        colors = ButtonDefaults.buttonColors(
            LightColor.PRIMARY
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.dropout_text),
            color = LightColor.WHITE,
            fontSize = 18.sp,
            fontWeight = FontWeight(700)
        )
    }
}

@Preview
@Composable
fun DropoutButtonPreview() {
    DropoutButton(){}
}