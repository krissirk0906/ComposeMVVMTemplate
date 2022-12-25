package com.example.androidhiltapp.ui.weather_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherCard() {
    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box()
        {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color.Cyan, shape = RoundedCornerShape(30.dp))
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Weather Card",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 20.dp),
                        color = Color.White
                    )
                    Text(
                        text = "25 C",
                        textAlign = TextAlign.Center,
                        fontSize = 50.sp,
                        modifier = Modifier.padding(top = 20.dp),
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(10.dp)).padding(top = (-25).dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Text(text = "Weather Card", textAlign = TextAlign.Center)
                    }
                }

            }
        }
    }
}

    @Composable
    @Preview
    fun PreviewWeatherCard() {
        WeatherCard()
    }