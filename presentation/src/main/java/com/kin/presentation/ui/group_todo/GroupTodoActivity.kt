package com.kin.presentation.ui.group_todo

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.deatil_group.DetailActivity
import com.kin.presentation.ui.group_list.screen.GroupListScreen
import com.kin.presentation.ui.group_todo.screen.GroupTodoScreen
import com.kin.presentation.ui.home.MainActivity
import com.kin.presentation.ui.home.screen.HomeScreen
import com.kin.presentation.viewmodel.GroupListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupTodoActivity: BaseActivity() {
    private val groupListViewModel by viewModels<GroupListViewModel>()
    override fun init() {
        setContent {
            GroupTodoScreen(
                onBackPage = {
                    pageMyGroup()
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
}