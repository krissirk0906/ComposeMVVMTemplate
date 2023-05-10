package com.junenine.composeWithMVVM.ui.components.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.junenine.composeWithMVVM.R
import com.junenine.composeWithMVVM.ui.base.BottomNavigationBar
import com.junenine.composeWithMVVM.ui.components.navigation.HomeNav

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                HomeNav(navController = navController)
            }
        },
        backgroundColor = colorResource(R.color.black) // Set background color to avoid the white flashing when you switch between screens
    )
}