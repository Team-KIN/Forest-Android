package com.kin.presentation.ui.deatil_group

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.deatil_group.screen.DetailGroupScreen
import com.kin.presentation.ui.group_list.GroupListActivity
import com.kin.presentation.ui.group_list.screen.GroupListScreen
import com.kin.presentation.ui.home.MainActivity
import com.kin.presentation.ui.home.screen.HomeScreen
import com.kin.presentation.viewmodel.GroupListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity: BaseActivity() {
    private val groupListViewModel by viewModels<GroupListViewModel>()
    override fun init() {
        setContent {
            DetailGroupScreen(
                context = this,
                onBack = {
                    pageBack()
                    finish()
                },
                onMyGroup = {
                    pageMyGroup()
                    finish()
                }
            )
        }
    }

    private fun pageBack() {
        startActivity(
            Intent(
                this,
                GroupListActivity::class.java
            )
        )
    }

    private fun pageMyGroup() {
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )
    }
}