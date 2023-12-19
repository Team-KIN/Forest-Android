package com.kin.presentation.ui.group_management.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun AllSelectButton() {
    Row(
        modifier = Modifier
            .width(105.dp)
            .height(24.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.all_select_icon),
                contentDescription = "all select"
            )
            Spacer(modifier = Modifier.width(1.dp))
            Text(
                text = stringResource(id = R.string.all_select_text),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(top = 1.dp),
                color = LightColor.SECONDARY
            )
        }
    }
}

@Preview
@Composable
fun AllSelectButtonPreview() {
    AllSelectButton()
}