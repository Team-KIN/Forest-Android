package com.kin.presentation.ui.my_page.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun WithdrawalButton(
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .width(320.dp)
            .height(34.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            LightColor.GRAY
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .width(77.dp)
                .height(20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.withdrawal_icon),
                contentDescription = "withdrawal icon",
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
                    .padding(top = 4.dp)
            )
            Text(
                text = stringResource(R.string.withdrawal_text),
                fontSize = 15.sp,
                fontWeight = FontWeight(600),
                color = LightColor.BLACK,
                modifier = Modifier.padding(start = 2.dp)
            )
        }
    }
}

@Preview
@Composable
fun WithdrawalButtonPreview(){
    WithdrawalButton(){}
}