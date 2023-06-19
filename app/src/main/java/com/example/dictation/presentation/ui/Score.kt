package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.Space

@Composable
fun Score(modifier: Modifier = Modifier, score: Int) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = stringResource(id = R.string.score_title), style = dictationTheme.typography.h1)
        Space(size = 64.dp)
        Text(text = score.toString())
    }
}