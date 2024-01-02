package com.kin.presentation.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kin.domain.model.main.response.MainModel
import com.kin.presentation.ui.change_password.screen.ChangePasswordScreen
import com.kin.presentation.ui.group_list.screen.GroupListScreen
import com.kin.presentation.ui.home.screen.HomeScreen
import com.kin.presentation.viewmodel.MainViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    mainData: MainModel,
    viewModel: MainViewModel
) {
    NavHost(navController = navController, startDestination = BottomNavItem.GroupList.screenRoute) {
        composable(BottomNavItem.MyGroup.screenRoute){
            HomeScreen(
                viewModel = viewModel,
                onDetailMyGroup = {}
                )
        }
        composable(BottomNavItem.GroupList.screenRoute) {
            // GroupListScreen(viewModel = )
        }
        composable(BottomNavItem.MyPage.screenRoute) {
            ChangePasswordScreen()
        }
    }
}
