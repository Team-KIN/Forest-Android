package com.kin.presentation.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kin.presentation.ui.change_password.screen.ChangePasswordScreen
import com.kin.presentation.ui.group_list.screen.GroupListScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.GroupList.screenRoute) {
        composable(BottomNavItem.GroupList.screenRoute) {
            GroupListScreen()
        }
        composable(BottomNavItem.MyPage.screenRoute) {
            ChangePasswordScreen(onClick = {})
        }
    }
}
