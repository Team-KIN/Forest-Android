package com.kin.presentation.ui.group_setting.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.component.back_page.BackPage
import com.kin.presentation.ui.group_setting.component.CodeCopyButton
import com.kin.presentation.ui.group_setting.component.GroupDeleteButton
import com.kin.presentation.ui.group_setting.component.GroupExplainEditButton
import com.kin.presentation.ui.group_setting.component.GroupExplainTextField
import com.kin.presentation.ui.group_setting.component.GroupGoalEditButton
import com.kin.presentation.ui.group_setting.component.GroupGoalTextField
import com.kin.presentation.ui.group_setting.component.GroupMemberEditButton
import com.kin.presentation.ui.group_setting.component.GroupMemberList
import com.kin.presentation.ui.group_setting.component.GroupSettingTitle
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun GroupSettingScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ){
        Column {
            Spacer(modifier = Modifier.height(4.dp))
            BackPage()
            Spacer(modifier = Modifier.height(19.dp))
            Row (
                modifier = Modifier.padding(start = 20.dp)
            ){
                GroupSettingTitle()
                Spacer(modifier = Modifier.width(139.dp))
                CodeCopyButton {}
            }
            Column (
                modifier = Modifier.padding(start = 20.dp)
            ){
                Spacer(modifier = Modifier.height(24.dp))
                GroupGoalEditButton {}
                Spacer(modifier = Modifier.height(4.dp))
                GroupGoalTextField(text = "공부 하려고")
                Spacer(modifier = Modifier.height(28.dp))
                GroupExplainEditButton {}
                Spacer(modifier = Modifier.height(4.dp))
                GroupExplainTextField(text = "이 나무는 모시깽이하는 나무인데\n" +
                        "과연 이놈이 침엽수인지 활엽수인지\n" +
                        "저로서는 도저히 알 수가 없는 그러한 그런\n" +
                        "모시깽이한 모시깽이라고 할 수 있습니다")
                Spacer(modifier = Modifier.height(28.dp))
                GroupMemberEditButton {}
                GroupMemberList()
                Spacer(modifier = Modifier.height(60.dp))
                Row {
                    Spacer(modifier = Modifier.width(10.dp))
                    GroupDeleteButton {}
                }
            }
        }
    }
}

@Preview
@Composable
fun GroupSettingScreenPreview(){
    GroupSettingScreen()
}