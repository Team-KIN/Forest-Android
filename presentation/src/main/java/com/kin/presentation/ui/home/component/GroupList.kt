package com.kin.presentation.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kin.domain.model.main.response.MainModel
import com.kin.presentation.ui.home.item.GroupItemList

@Composable
fun GroupList(
    data: MainModel,
    onDetailMyGroup: () -> Unit
) {
    Box(
    ){
        LazyColumn(
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onDetailMyGroup()
            }
        ) {
            items(data.groups){
                GroupItemList(
                    data = it,
                    onDetailMyGroup = { onDetailMyGroup() }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun GroupListPreview(){
    // GroupList()
}