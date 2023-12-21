package com.kin.presentation.ui.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.domain.model.main.response.MainModel
import androidx.compose.ui.Alignment
import com.kin.presentation.ui.home.component.Bottom
import com.kin.presentation.ui.home.component.Divider
import com.kin.presentation.ui.home.component.ExtraList
import com.kin.presentation.ui.home.component.GroupList
import com.kin.presentation.ui.home.component.MyGroupTitle
import com.kin.presentation.ui.home.component.Profile
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.viewmodel.MainViewModel
import com.kin.presentation.viewmodel.util.Event

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    onGroupClick: () -> Unit,
    onMyPageClick: () -> Unit,
    onDetailMyGroup: () -> Unit
) {
    val data = viewModel.mainData.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightColor.WHITE)
    ){
        Column {
            Row (
                modifier = Modifier.padding(top = 40.dp, start = 16.dp)
            ){
                if (data != null) {
                    Profile(
                        name = data.name,
                        email = data.email
                    )
                }
            }
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 17.dp)
            ){
                Divider()
                Spacer(modifier = Modifier.height(28.dp))
                MyGroupTitle()
                Spacer(modifier = Modifier.height(20.dp))
                if (data != null) {
                    GroupList(
                        data = data.groups
                    ) { onDetailMyGroup() }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 123.dp)
            ){
                ExtraList()
            }
            Column(
                modifier = Modifier.padding(top = 61.dp)
            ) {
                Bottom(
                    { onGroupClick() },
                    { onMyPageClick() }
                )
            }
        }
    }
}

suspend fun getMainPageInfo(
    viewModel: MainViewModel,
    progressState: (Boolean) -> Unit,
    onSuccess: (mainInfo: MainModel) -> MainModel
){
    viewModel.mainResponse.collect{ response ->
        when(response){
            is Event.Loading -> {
                progressState(true)
            }

            is Event.Success -> {
                progressState(false)
                onSuccess(response.data!!)
            }

            else -> {
                progressState(false)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    // HomeScreen()
}