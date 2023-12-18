package com.kin.presentation.ui.home.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.teamgrapefruit.presentation.R

@Composable
fun GroupItemList(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .size(192.dp, 34.dp)
                .background(
                    color = LightColor.GRAY,
                    shape = RoundedCornerShape(17.dp)
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Text(
                text = "모여봐요 공부의 숲",
                color = LightColor.BLACK,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "Search Icon"
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Row() {
            Row() {
                Image(painter = painterResource(id = R.drawable.member_icon),
                    contentDescription = "Member Icon"
                )
                Text(
                    text = "99+",
                    color = LightColor.SECONDARY,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.todo_icon),
                    contentDescription = "Member Icon"
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "99+",
                    color = LightColor.SECONDARY,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun GroupItemListPreview(){
    GroupItemList()
}