package com.example.rustoreapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    onSecondary = Color.White,
    surface = LightBlueSurface,
    onSurface = Color(0xFF000000),
    onSurfaceVariant = Color(0xFF666666),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000)
)

@Composable
fun RuStoreAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}