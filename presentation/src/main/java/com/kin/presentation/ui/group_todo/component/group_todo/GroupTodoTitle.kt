package com.kin.presentation.ui.group_todo.component.group_todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.R

@Composable
fun GroupTodoTitle(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.width(360.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.Center) {
            Button(
                modifier = Modifier
                    .width(76.dp)
                    .height(26.dp),
                colors = ButtonDefaults.buttonColors(
                    LightColor.GRAY
                ),
                shape = RoundedCornerShape(12.dp),
                onClick = { onClick() }
            ) {}
            Text(
                text = stringResource(R.string.group_todo),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = LightColor.GROUPTODO,
                modifier = Modifier
                    .width(68.dp)
                    .height(22.dp)
            )
        }
        Text(
            text = "50%",
            fontSize = 14.sp,
            color = LightColor.GROUPTODO
        )
    }
}

@Preview
@Composable
fun GroupTodoTitlePreview() {
    GroupTodoTitle {}
}