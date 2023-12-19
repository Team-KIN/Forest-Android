package com.kin.presentation.ui.home.screen

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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.presentation.ui.home.component.Divider
import com.kin.presentation.ui.home.component.ExtraList
import com.kin.presentation.ui.home.component.GroupList
import com.kin.presentation.ui.home.component.MyGroupTitle
import com.kin.presentation.ui.home.component.Profile
import com.kin.presentation.ui.theme.color.LightColor

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ){
        Column {
            Row (
                modifier = Modifier.padding(top = 40.dp, start = 16.dp)
            ){
                Profile()
            }
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 17.dp)
            ){
                Divider()
                Spacer(modifier = Modifier.height(28.dp))
                MyGroupTitle()
                Spacer(modifier = Modifier.height(20.dp))
                GroupList()
                Spacer(modifier = Modifier.height(20.dp))
            }
            Column(
                modifier = Modifier.padding(start = 123.dp)
            ){
                ExtraList()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}