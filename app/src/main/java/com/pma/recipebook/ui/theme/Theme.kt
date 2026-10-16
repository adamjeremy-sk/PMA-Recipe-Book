package com.pma.recipebook.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.weatherapp.theme.BoutiqueThemeEngine
import com.weatherapp.theme.ColorPalette
import com.weatherapp.theme.ThemeMode

val LocalColorPalette = staticCompositionLocalOf { BoutiqueThemeEngine.LIGHT_PALETTE }

fun ColorPalette.toColorScheme(isDark: Boolean): ColorScheme {
    return ColorScheme(
        primary = Color(primary),
        onPrimary = Color(textPrimary),
        primaryContainer = Color(surfaceCardSecondary),
        onPrimaryContainer = Color(textPrimary),
        inversePrimary = Color(brandPrimary),
        secondary = Color(blueHourPrimary),
        onSecondary = Color(textPrimary),
        secondaryContainer = Color(tempLowBg),
        onSecondaryContainer = Color(textSecondary),
        tertiary = Color(goldenHourPrimary),
        onTertiary = Color(textPrimary),
        tertiaryContainer = Color(tempHighBg),
        onTertiaryContainer = Color(tempHigh),
        background = Color(background),
        onBackground = Color(textPrimary),
        surface = Color(surfaceCard),
        onSurface = Color(textPrimary),
        surfaceVariant = Color(surfaceCardSecondary),
        onSurfaceVariant = Color(textSecondary),
        surfaceTint = Color(primary),
        inverseSurface = Color(textPrimary),
        inverseOnSurface = Color(background),
        error = Color(alertExtreme),
        onError = Color.White,
        errorContainer = Color(tempHighBg),
        onErrorContainer = Color(alertExtreme),
        outline = Color(dividerColor),
        outlineVariant = Color(dividerColor),
        scrim = Color.Black,
        surfaceContainer = Color(surfaceCard),
        surfaceContainerHigh = Color(surfaceCardSecondary),
        surfaceContainerHighest = Color(surfaceCardSecondary),
        surfaceContainerLow = Color(background),
        surfaceContainerLowest = Color(background),
        surfaceBright = Color(surfaceCard),
        surfaceDim = Color(surfaceCardSecondary)
    )
}

@Composable
fun PMARecipeBookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    themeMode: Int = if (darkTheme) ThemeMode.DARK else ThemeMode.LIGHT,
    content: @Composable () -> Unit
) {
    val palette = BoutiqueThemeEngine.getThemePalette(themeMode)
    val colorScheme = palette.toColorScheme(darkTheme)

    CompositionLocalProvider(LocalColorPalette provides palette) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
