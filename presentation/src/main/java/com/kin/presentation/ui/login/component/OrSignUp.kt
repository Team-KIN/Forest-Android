package com.kin.presentation.ui.login.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R


@Composable
fun OrSignUp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.or),
            color = LightColor.BLACK,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.sign_up_text),
            color = LightColor.SECONDARY,
            fontSize = 15.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrSignUpPreview() {
    OrSignUp()
}