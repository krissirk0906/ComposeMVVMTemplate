package com.junenine.mvvmcompose.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.junenine.mvvmcompose.ui.components.main.MainScreen
import com.junenine.mvvmcompose.ui.components.on_boarding.OnBoardingScreen
import com.junenine.mvvmcompose.ui.components.splash_screen.SplashScreen

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
        composable(route = Screen.OnBoarding.route)
        {
            OnBoardingScreen(navController = navController)
        }
    }
}