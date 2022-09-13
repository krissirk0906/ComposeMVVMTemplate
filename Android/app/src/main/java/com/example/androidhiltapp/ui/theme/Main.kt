package com.example.androidhiltapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidhiltapp.MyViewModel
import com.example.androidhiltapp.data.model.SampleResponse

@Composable
fun Main() {
    val viewModel = hiltViewModel<MyViewModel>()
    AppTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
        ) {
            val quote: SampleResponse? by viewModel.quote.observeAsState()
            Text(text = quote?.content ?: "", color = Color.White, fontSize = 30.sp)
        }
    }
}