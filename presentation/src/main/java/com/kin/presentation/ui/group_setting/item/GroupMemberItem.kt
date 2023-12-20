package com.kin.presentation.ui.group_setting.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.kin.presentation.R

@Composable
fun GroupMemberItem() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .padding(1.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "홍길동",
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            color = LightColor.BLACK
            )
    }
}

@Preview
@Composable
fun GroupMemberItemPreview() {
    GroupMemberItem()
}