package com.junenine.composeTemplate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
private val LightColorScheme = lightColorScheme(
    primary = Purple200,
    onPrimary = Purple500,
    primaryContainer = Purple700,
    onPrimaryContainer = Teal200,
)
private val DarkColorScheme = darkColorScheme(
    primary = Purple200,
    onPrimary = Purple500,
    primaryContainer = Purple700,
    onPrimaryContainer = Teal200,
)
@Composable
fun AppTheme(
    darkTheme : Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme =
    if (!darkTheme) {
        LightColorScheme
    } else {
        DarkColorScheme
    }
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
}
