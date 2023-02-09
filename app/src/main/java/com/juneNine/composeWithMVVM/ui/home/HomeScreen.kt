package com.juneNine.composeWithMVVM.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juneNine.composeWithMVVM.ui.theme.AppTheme
import com.juneNine.composeWithMVVM.ui.weather_card.WeatherCard

@Composable
fun HomeScreen() {
    AppTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Text(text = "Home Screen", modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp), textAlign = TextAlign.Center, fontSize = 20.sp)
            WeatherCard()
        }
    }
}