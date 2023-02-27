package com.juneNine.composeWithMVVM.ui.navigation

import com.juneNine.composeWithMVVM.R


sealed class Screen(val route: String,var icon : Int,var title : String){
    object Splash : Screen("splash_screen", R.drawable.ic_launcher_background,"Splash Screen")
    object Home : Screen("home_screen",R.drawable.ic_launcher_background,"Home Screen")
    object Main : Screen("main_screen",R.drawable.ic_launcher_background,"Main Screen")
}