package com.junenine.mvvmcompose.ui.components.on_boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.junenine.mvvmcompose.R
import com.junenine.mvvmcompose.ui.components.navigation.Screen
import vn.junenine.moma.ui.base.JuneNineButton

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF622FB5),
                        Color(0xFF1B0F36)
                    )
                )
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .padding(top = 25.dp, start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Sunny",
                    modifier = Modifier.size(130.dp),
                    alignment = Alignment.TopStart
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "cloudy",
                    modifier = Modifier.size(130.dp),
                    alignment = Alignment.TopEnd
                )
            }
            Column() {
                Spacer(modifier = Modifier.size(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "night",
                    modifier = Modifier
                        .size(130.dp),
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "snow",
                    modifier = Modifier
                        .size(130.dp),
                )
            }

        }
        Spacer(modifier = Modifier.size(10.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Text(
                text = "My weather app",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Check Live weather updates\n" +
                        "all over the world with just one tap",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.size(60.dp))
            JuneNineButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(98.dp),
                backgroundColor = Color(0xFF7F4CD2),
                text = "Get Started",
                onClick = { navController.navigate(Screen.Main.route) },
                textSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                shape = RoundedCornerShape(25.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
        }

    }
}