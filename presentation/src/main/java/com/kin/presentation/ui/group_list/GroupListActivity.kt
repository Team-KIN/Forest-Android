package com.kin.presentation.ui.group_list

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.group_list.screen.GroupListScreen
import com.kin.presentation.ui.home.screen.HomeScreen
import com.kin.presentation.viewmodel.GroupListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupListActivity: BaseActivity() {
    private val groupListViewModel by viewModels<GroupListViewModel>()
    override fun init() {
        setContent {
            GroupListScreen(viewModel = groupListViewModel)
        }
    }
}