package com.juneNine.composeWithMVVM

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.juneNine.composeWithMVVM.ui.home.HomeScreen
import com.juneNine.composeWithMVVM.ui.navigation.MainNav
import com.juneNine.composeWithMVVM.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = false) {
                val navController = rememberNavController()
                MainNav(navController = navController)
            }
        }
    }
}