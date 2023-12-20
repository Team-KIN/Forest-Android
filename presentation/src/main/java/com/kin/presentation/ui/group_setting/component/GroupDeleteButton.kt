package com.kin.presentation.ui.group_setting.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
fun GroupDeleteButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick },
        modifier = Modifier
            .width(320.dp)
            .height(52.dp),
        colors = ButtonDefaults.buttonColors(
            LightColor.PRIMARY
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.group_delete_text),
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            color = LightColor.WHITE
        )
    }
}

@Preview
@Composable
fun GroupDeleteButtonPreview() {
    GroupDeleteButton(){}
}