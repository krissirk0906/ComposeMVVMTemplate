package com.junenine.mvvmcompose.ui.components


sealed class Screen(val route: String,var icon : Int,var title : String){
    object Splash : Screen("splash_screen", coil.base.R.drawable.ic_100tb,"Splash Screen")
    object Home : Screen("home_screen",coil.base.R.drawable.ic_100tb,"Home Screen")
    object Main : Screen("main_screen",coil.base.R.drawable.ic_100tb,"Main Screen")
    object Login : Screen("login_screen",coil.base.R.drawable.ic_100tb,"Login Screen")
    object OnBoarding : Screen("onboarding",coil.base.R.drawable.ic_100tb,"OnBoarding")
}