package com.kin.presentation.ui.group_list.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.domain.model.group_list.response.GroupListModel
import com.kin.presentation.ui.group_list.component.Bottom
import com.kin.presentation.ui.group_list.component.GroupList
import com.kin.presentation.ui.group_list.component.GroupListTitle
import com.kin.presentation.ui.group_list.component.OptionButton
import com.kin.presentation.ui.theme.color.LightColor
import com.kin.presentation.viewmodel.GroupListViewModel
import com.kin.presentation.viewmodel.util.Event

@Composable
fun GroupListScreen(
    viewModel: GroupListViewModel,
    onMyGroupClick: () -> Unit,
    onMyPageClick: () -> Unit,
    onDetail: () -> Unit,
    onCreateGroup: () -> Unit
) {


    val progressState = remember { mutableStateOf(false) }
    
//    LaunchedEffect("GetGroupList") {
//        viewModel.getAccessToken()
//        viewModel.getGroupList()
//        getGroupList(
//            viewModel = viewModel,
//            progressState = { progressState.value = it }
//        )
//        Log.d("LaunchedEffect: List", "작동")
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightColor.WHITE)
    ) {
        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            GroupListTitle(
                { onDetail() }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.size(344.dp,655.dp),
            contentAlignment = Alignment.Center
        ) {
            GroupList(
                { onDetail() }
                // groupList = viewModel.groupList
            )
        }
        Bottom(
            { onMyGroupClick() },
            { onMyPageClick() }
        )
    }
    Column(modifier = Modifier.padding(start = 320.dp)) {
        Spacer(modifier = Modifier.height(572.dp))
        OptionButton {
            onCreateGroup()
        }
    }
}
suspend fun getGroupList(
    viewModel: GroupListViewModel,
    progressState: (Boolean) -> Unit
) {
    viewModel.getGroupListResponse.collect { response ->
        Log.d("groupList", "작동")
        when(response) {
            is Event.Success -> {
                Log.d("groupList", "성공${response.data!!.groups}")
                progressState(false)
            }

            is Event.Loading -> {
                Log.d("groupList", "작동중")
                progressState(true)
            }

            else -> {
                Log.d("groupList", "실패")
                progressState(false)
            }
        }
    }
}

@Preview
@Composable
fun GroupListScreenPreview() {
    // GroupListScreen()
}