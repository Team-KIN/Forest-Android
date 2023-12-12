package com.kin.presentation.ui.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamgrapefruit.presentation.R

@Composable
fun Title() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.forest_title),
            contentDescription = "Title icon",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(210.dp, 100.dp)
        )
    }

}

@Preview
@Composable
fun TitlePreview() {
    Title()
}
