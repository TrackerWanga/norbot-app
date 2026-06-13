package com.megan.bot.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Norbot Color Palette
val NorbotPurple = Color(0xFF7C3AED)
val NorbotCyan = Color(0xFF06B6D4)
val NorbotNeonGreen = Color(0xFF00FF88)
val NorbotDark = Color(0xFF0A0A0F)
val NorbotDarkCard = Color(0xFF1A1A2E)
val NorbotGlass = Color(0x1AFFFFFF)
val NorbotTextPrimary = Color(0xFFF8FAFC)
val NorbotTextSecondary = Color(0xFF94A3B8)
val NorbotError = Color(0xFFEF4444)
val NorbotSuccess = Color(0xFF22C55E)
val NorbotWarning = Color(0xFFF59E0B)

private val NorbotDarkColorScheme = darkColorScheme(
    primary = NorbotPurple,
    secondary = NorbotCyan,
    tertiary = NorbotNeonGreen,
    background = NorbotDark,
    surface = NorbotDarkCard,
    surfaceVariant = NorbotGlass,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = NorbotTextPrimary,
    onSurface = NorbotTextPrimary,
    onSurfaceVariant = NorbotTextSecondary,
    error = NorbotError,
    onError = Color.White
)

@Composable
fun NorbotTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NorbotDarkColorScheme,
        typography = Typography(),
        content = content
    )
}
