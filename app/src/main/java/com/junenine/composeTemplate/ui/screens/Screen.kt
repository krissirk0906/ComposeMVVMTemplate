package com.junenine.composeTemplate.ui.screens


sealed class Screen(val route: String,var icon : Int,var title : String){
    data object Home : Screen("home_screen",coil.base.R.drawable.ic_100tb,"Home Screen")
    data object Main : Screen("main_screen",coil.base.R.drawable.ic_100tb,"Main Screen")
}