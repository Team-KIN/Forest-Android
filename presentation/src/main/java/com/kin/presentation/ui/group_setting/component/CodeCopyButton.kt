package com.kin.presentation.ui.group_setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun CodeCopyButton(onClick: () -> Unit) {
    TextButton(onClick = { onClick }) {
        Row {
            Text(
                text = stringResource(id = R.string.copy_code_text),
                fontSize = 15.sp,
                fontWeight = FontWeight(500),
                color = LightColor.SECONDARY,
                modifier = Modifier.padding(top = 2.dp, end = 4.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.copy_code_icon),
                contentDescription = "copy code icon",
                modifier = Modifier
                    .padding(1.dp)
                    .width(24.dp)
                    .height(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun CodeCopyButtonPreview() {
    CodeCopyButton(){}
}