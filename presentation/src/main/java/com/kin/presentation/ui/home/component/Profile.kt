package com.kin.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R

@Composable
fun Profile() {
    Box(modifier = Modifier
        .width(174.dp)
        .height(40.dp)
    ) {
        Column (
            modifier = Modifier.border(
                width = 1.dp,
                color = LightColor.PRIMARY,
                shape = CircleShape
            )
        ){
            Image(
                painter = painterResource(R.drawable.profile_image),
                contentDescription = "profile image",
                modifier = Modifier.clip(CircleShape)
            )
        }

        Text(
            text = "홍길동",
            fontSize = 16.sp,
            color = LightColor.BLACK,
            fontWeight = FontWeight(700),
            modifier = Modifier.padding(start = 52.dp)
        )
        Text(
            text = "s24000@gsm.hs.kr",
            fontSize = 14.sp,
            color = LightColor.GRAY2,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(
                start = 52.dp,
                top = 20.dp
            )
        )
    }
}

@Preview
@Composable
fun ProfilePreview() {
    Profile()
}