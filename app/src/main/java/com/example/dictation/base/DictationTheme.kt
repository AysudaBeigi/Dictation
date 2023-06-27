package com.example.dictation.base

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

@Composable
fun DictationTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        MaterialTheme(
            colors = color,
            typography = dictationTypography,
            content = content,
        )
    }

}

val dictationTheme = DictationTheme()

data class DictationTheme(
    val colors: DictationColor = DictationColor(),
    val typography: Typography = dictationTypography,
    val shapes: DictationShapes = DictationShapes(),
)