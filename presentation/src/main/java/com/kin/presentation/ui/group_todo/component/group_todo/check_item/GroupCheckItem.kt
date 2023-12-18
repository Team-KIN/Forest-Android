package com.kin.presentation.ui.group_todo.component.group_todo.check_item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupCheckItem() {
    var checked by remember { mutableStateOf(false) }
    val backgroundColor = if (checked) LightColor.GROUPTODO else LightColor.GRAY

    Row(
        modifier = Modifier.size(360.dp, 56.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(8.dp)
                )
                .size(24.dp, 24.dp)
                .clickable { checked = !checked },
            contentAlignment = Alignment.Center
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = LightColor.GROUPTODO,
                    uncheckedColor = LightColor.GRAY
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "야너두 TOEIC 문제집 ~p100까지 풀기\n" +
                    "영어 지문 독해하기",
            fontSize = 16.sp,
            color = LightColor.BLACK,
            modifier = Modifier.size(258.dp, 48.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "50%",
            fontSize = 16.sp,
            color = LightColor.GRAY
        )
    }
}

@Preview
@Composable
fun GroupCheckItemPreview() {
    GroupCheckItem()
}