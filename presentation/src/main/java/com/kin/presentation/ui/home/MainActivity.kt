package com.kin.presentation.ui.home

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.compose.rememberNavController
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.component.navigation.BottomNavigationBar
import com.kin.presentation.ui.component.navigation.NavigationGraph
import com.kin.presentation.ui.group_list.GroupListActivity
import com.kin.presentation.ui.group_todo.GroupTodoActivity
import com.kin.presentation.ui.home.screen.HomeScreen
import com.kin.presentation.ui.signup.SignUpActivity
// import com.kin.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    // private val mainViewModel by viewModels<MainViewModel>()
    override fun init() {
        // mainViewModel.main()
        setContent {
            HomeScreen(
                onGroupClick = {
                    pageGroup()
                    finish()
                },
                onMyPageClick = {

                },
                onDetailMyGroup = {
                    pageDetailMyGroup()
                }
            )
        }
    }
    private fun pageGroup() {
        startActivity(
            Intent(
                this,
                GroupListActivity::class.java
            )
        )
    }

    private fun pageDetailMyGroup() {
        startActivity(
            Intent(
                this,
                GroupTodoActivity::class.java
            )
        )
    }
    private fun pageMy() {

    }
}


//@Composable
//fun MainPageView() {
//    val navController = rememberNavController()
//    Scaffold (
//        bottomBar = { BottomNavigationBar(navController = navController)}
//    ){
//        Box(modifier = Modifier.padding(it)){
//            NavigationGraph(navController = navController)
//        }
//    }
//}