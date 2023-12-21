package com.kin.presentation.ui.group_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.domain.model.group_list.response.GroupListModel
import com.kin.presentation.ui.group_list.item.GroupItemList

@Composable
fun GroupList(
    groupList: List<GroupListModel>
) {
    Box(
    ) {
        LazyColumn {
            items(groupList.size){ index ->
                GroupItemList(
                    groupList[index].id,
                    groupList[index].name,
                    groupList[index].headcount,
                    groupList[index].todo
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun GroupListPreview() {
    // GroupList()
}