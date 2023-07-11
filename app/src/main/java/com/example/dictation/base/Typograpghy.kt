package com.example.dictation.base

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dictation.R


val dictationTypography = Typography(
    h1 = TextStyle(
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    ),
    h2 = TextStyle(
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    ),
    h3 = TextStyle(
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    ),
    h6 = TextStyle(
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
    ),
    h4 = TextStyle(
        color = Color.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    ),
    h5 = TextStyle(
        color = Color.Black,
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    ),
)
