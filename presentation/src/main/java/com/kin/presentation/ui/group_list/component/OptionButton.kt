package com.kin.presentation.ui.group_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun OptionButton(
    onClick: () -> Unit
) {
    Box() {
        Button(
            modifier = Modifier
                .width(64.dp)
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                LightColor.PRIMARY
            ),
            shape = RoundedCornerShape(32.dp),
            onClick = { onClick() }
        ) {}
        Image(
            painter = painterResource(id = R.drawable.option_icon),
            contentDescription = "Option Icon",
        )
    }
}

@Preview
@Composable
fun OptionButtonPreview() {
    OptionButton{}
}