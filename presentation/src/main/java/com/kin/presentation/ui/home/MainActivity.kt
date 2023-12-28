package com.kin.presentation.ui.home

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.kin.domain.model.main.response.MainModel
import com.kin.presentation.ui.base.BaseActivity
import com.kin.presentation.ui.component.navigation.BottomNavigationBar
import com.kin.presentation.ui.component.navigation.NavigationGraph
import com.kin.presentation.viewmodel.MainViewModel
import com.kin.presentation.viewmodel.util.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun init() {
        setContent {
            MainPageView(
                viewModel = mainViewModel
            )
        }
    }
}

@Composable
fun MainPageView(
    viewModel: MainViewModel
) {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { BottomNavigationBar(navController = navController)}
    ){
        Box(modifier = Modifier.padding(it)){
            viewModel.mainData.value?.let { it1 ->
                NavigationGraph(
                    navController = navController,
                    viewModel = viewModel,
                    mainData = it1
                )
            }
        }
    }
}

@Preview
@Composable
fun MainPagePreview() {
    // MainPageView()
}