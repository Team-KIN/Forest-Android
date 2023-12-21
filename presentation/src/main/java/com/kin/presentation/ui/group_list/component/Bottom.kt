package com.kin.presentation.ui.group_list.component

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.kin.presentation.R
import com.kin.presentation.ui.group_list.GroupListActivity
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun Bottom(
    onMyGroupClick: () -> Unit,
    onMyPageClick: () -> Unit
) {
    Box() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LightColor.WHITE),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.group),
                contentDescription = "notGroup",
            )
            Image(
                painter = painterResource(R.drawable.not_mygroup),
                contentDescription = "notGroup",
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onMyGroupClick()
                }
            )
            Image(
                painter = painterResource(R.drawable.not_mypage),
                contentDescription = "notGroup",
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onMyPageClick()
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomPreview() {
    // Bottom()
}