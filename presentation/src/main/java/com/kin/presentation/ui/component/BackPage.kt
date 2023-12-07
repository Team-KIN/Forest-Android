package com.kin.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamgrapefruit.presentation.R

@Composable
fun BackPage() {
    Box() {
        Row() {
            Image(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "Back icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(24.dp, 24.dp)
            )
            Text(
                text = stringResource(R.string.back_page_text),
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(0.dp, 3.dp)
            )
        }
    }
}

@Preview
@Composable
fun BackPagePreview() {
    BackPage()
}