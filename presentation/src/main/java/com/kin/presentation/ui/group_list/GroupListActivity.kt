package com.kin.presentation.ui.group_list

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.create_group.CreateGroupActivity
import com.kin.presentation.ui.deatil_group.DetailActivity
import com.kin.presentation.ui.group_list.screen.GroupListScreen
import com.kin.presentation.ui.home.MainActivity
import com.kin.presentation.ui.home.screen.HomeScreen
import com.kin.presentation.viewmodel.GroupListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupListActivity : BaseActivity() {
    private val groupListViewModel by viewModels<GroupListViewModel>()
    override fun init() {
        setContent {
            GroupListScreen(
                // viewModel = groupListViewModel,
                onMyGroupClick = {
                    pageMyGroup()
                    finish()
                },
                onMyPageClick = { },
                onDetail = {
                    pageDetailPage()
                    finish()
                },
                onCreateGroup = {
                    pageCreateGroup()
                    finish()
                }
            )
        }
    }

    private fun pageMyGroup() {
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )
    }

    private fun pageDetailPage() {
        startActivity(
            Intent(
                this,
                DetailActivity::class.java
            )
        )
    }

    private fun pageCreateGroup() {
        startActivity(
            Intent(
                this,
                CreateGroupActivity::class.java
            )
        )
    }
}