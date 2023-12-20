package com.kin.presentation.ui.group_setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun GroupMemberEditButton(onClick: () -> Unit){
    TextButton(onClick = { onClick }) {
        Row {
            Text(
                text = stringResource(id = R.string.group_member_text),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = LightColor.GRAY2
            )
            Image(
                painter = painterResource(id = R.drawable.member_setting_icon),
                contentDescription = "edit icon",
                modifier = Modifier.padding(top = 2.dp, start = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun GroupMemberEditButtonPreview(){
    GroupMemberEditButton(){}
}