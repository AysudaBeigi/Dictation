package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Score(modifier: Modifier= Modifier){
    Column (modifier = modifier.fillMaxSize()){
        Text(text = "Your score is :")
    }
}