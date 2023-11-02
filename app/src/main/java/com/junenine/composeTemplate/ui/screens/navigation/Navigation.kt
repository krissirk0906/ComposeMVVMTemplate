package com.junenine.composeTemplate.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.junenine.composeTemplate.ui.screens.Screen
import com.junenine.composeTemplate.ui.screens.home.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Main.route)
        {
            HomeScreen()
        }
    }
}