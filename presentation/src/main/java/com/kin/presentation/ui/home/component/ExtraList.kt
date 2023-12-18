package com.kin.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R

@Composable
fun ExtraList() {
    Row(
        modifier = Modifier
            .width(74.dp)
            .height(18.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.kebab_menu_icon),
            contentDescription = "",
            modifier = Modifier
                .width(16.dp)
                .height(16.dp)
                .padding(top = 2.dp)
        )
        Text(
            text = stringResource(R.string.extra_list_text),
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = LightColor.GRAY3,
            modifier = Modifier.padding(start = 4.dp)
        )
    }

}

@Preview
@Composable
fun ExtraListPreview() {
    ExtraList()
}