package com.junenine.mvvmcompose.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.junenine.mvvmcompose.ui.theme.AppTheme

@Composable
fun HomeScreen(navController: NavController) {
    val isChecked = remember { mutableStateOf(false) }
    AppTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Text(text = "Home Screen", modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp), textAlign = TextAlign.Center, fontSize = 20.sp)
            Switch(
                checked = isChecked.value,
                onCheckedChange = { /*...*/ },
                thumbContent = {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "checked"
                    )
                },
            )
            ExtendedFloatingActionButton(onClick = { /* do something */ }) {
                Text(text = "Extended FAB")
            }
        }
    }
}