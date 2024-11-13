package com.junenine.composeTemplate.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.junenine.composeTemplate.ui.screens.navigation.Navigation
import com.junenine.composeTemplate.ui.theme.AppTheme
import com.junenine.crashcatcher.CrashHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CrashHandler.initialize(this)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AppTheme(darkTheme = false) {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}