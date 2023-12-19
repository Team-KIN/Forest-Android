package com.kin.presentation.ui.my_page.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun ProfileImage() {
    Box(
        modifier = Modifier
            .width(48.dp)
            .height(48.dp)
    ) {
        Column(
            modifier = Modifier.border(
                width = 1.dp,
                color = LightColor.PRIMARY,
                shape = CircleShape
            )
        ) {
            Image(
                painter = painterResource(R.drawable.profile_image),
                contentDescription = "profile image",
                modifier = Modifier
                    .clip(CircleShape)
                    .width(48.dp)
                    .height(48.dp)
            )
        }
        Box(
            modifier = Modifier
                .width(17.dp)
                .height(17.dp)
                .align(Alignment.BottomEnd)
        ) {
            Image(
                painter = painterResource(R.drawable.profile_shuffle_icon),
                contentDescription = "profile shuffle"
            )
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    ProfileImage()
}