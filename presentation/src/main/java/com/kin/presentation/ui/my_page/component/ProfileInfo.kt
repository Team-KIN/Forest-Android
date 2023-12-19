package com.kin.presentation.ui.my_page.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.R
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun ProfileInfo() {
    Box(
        modifier = Modifier
            .width(122.dp)
            .height(38.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .width(62.dp)
                    .height(20.dp)
            ) {
                Text(
                    text = "홍길동",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding()
                )
                Image(
                    painter = painterResource(R.drawable.edit_icon),
                    contentDescription = "edit icon",
                    modifier = Modifier
                        .padding(top = 2.dp, start = 2.dp)
                )
            }
            Text(
                text = "s24000@gsm.hs.kr",
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = LightColor.GRAY2
            )
        }

    }
}

@Preview
@Composable
fun ProfileInfoPreview() {
    ProfileInfo()
}