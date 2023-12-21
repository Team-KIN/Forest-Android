package com.kin.presentation.ui.home

import android.content.Intent
import androidx.activity.compose.setContent
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.home.screen.HomeScreen
// import com.kin.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    // private val mainViewModel by viewModels<MainViewModel>()
    override fun init() {
        // mainViewModel.main()
        setContent {
            HomeScreen(
                onDetailMyGroup = {

                }
            )
        }
    }
//    private fun pageGroup() {
//        startActivity(
//            Intent(
//                this,
//                GroupListActivity::class.java
//            )
//        )
//    }

//    private fun pageDetailMyGroup() {
//        startActivity(
//            Intent(
//                this,
//                GroupTodoActivity::class.java
//            )
//        )
//    }
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