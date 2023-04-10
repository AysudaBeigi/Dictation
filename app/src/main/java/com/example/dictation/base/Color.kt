package com.example.dictation.base

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

data class DictationColor(
    val darkBackground: Color = Color(0xFF2F364E),
    val white: Color = Color(0xFFFFFFFF),
    val green: Color = Color(0xFF2ED273),
    val lightGreen: Color = Color(0xFF66E49B),
    val darkGreen: Color = Color(0xFF09CCA5),
    val darkRed: Color = Color(0xFFFF6976),
    val lightRed: Color = Color(0xFFFF808B),
    val gray: Color = Color(0xFFB0B0B0),
    val primary: Color = Color(0xFF141A30),
    val lightPurple: Color = Color(0xFF5467FF),
    val separatorColor: Color = Color(0xFFCCDAFF),
)

private val dictationColor = DictationColor()
val color = darkColors(
    primary = dictationColor.primary,
    secondary = dictationColor.darkBackground,
    background = dictationColor.darkBackground,
    error = dictationColor.darkRed,
    onPrimary = dictationColor.white,
)
