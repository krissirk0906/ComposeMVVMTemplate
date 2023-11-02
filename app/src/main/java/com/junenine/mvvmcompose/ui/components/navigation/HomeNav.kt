package com.junenine.mvvmcompose.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.junenine.mvvmcompose.ui.components.Screen
import com.junenine.mvvmcompose.ui.components.home.HomeScreen

@Composable
fun HomeNav(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}