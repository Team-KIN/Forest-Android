package com.kin.presentation.ui.home

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.home.screen.HomeScreen
import com.kin.presentation.viewmodel.GroupListViewModel
import dagger.hilt.android.AndroidEntryPoint

//enum class HomePage(val value: String) {
//    Home("Home"),
//    GroupList("GroupList")
//}
@AndroidEntryPoint
class HomeActivity: BaseActivity() {
    private val groupListViewModel by viewModels<GroupListViewModel>()
    override fun init() {
        setContent {
            HomeScreen()
        }
    }
}