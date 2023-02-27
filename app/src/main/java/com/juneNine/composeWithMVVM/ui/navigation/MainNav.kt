package com.juneNine.composeWithMVVM.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juneNine.composeWithMVVM.ui.main.MainScreen
import com.juneNine.composeWithMVVM.ui.splash_screen.SplashScreen

@Composable
fun MainNav(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Main.route)
        {
            MainScreen()
        }
    }
}