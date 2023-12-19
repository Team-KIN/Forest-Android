package com.kin.presentation.ui.group_management.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
fun GroupMemberItem(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .width(320.dp)
            .height(48.dp),
        onClick = { onClick },
        colors = ButtonDefaults.buttonColors(
            LightColor.GRAY
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "profile image",
                modifier = Modifier.clip(shape = CircleShape)
            )
            Text(
                text = "홍길동",
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = LightColor.BLACK,
                modifier = Modifier.padding(start = 12.dp, top = 3.dp)
            )
            Spacer(modifier = Modifier.width(160.dp))
            Image(
                painter = painterResource(id = R.drawable.radio_button_icon_false),
                contentDescription = "radio button",
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}

@Preview
@Composable
fun GroupMemberItemPreview() {
    GroupMemberItem() {}
}