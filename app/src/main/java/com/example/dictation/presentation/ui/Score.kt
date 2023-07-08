package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.Space

@Composable
fun Score(modifier: Modifier = Modifier, score: Int) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = dictationTheme.colors.yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_score),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )
        Space(size = 64.dp)
        Text(
            text = stringResource(id = R.string.score_title),
            style = dictationTheme.typography.h1
        )
        Space(size = 32.dp)
        Text(text = score.toString(), style = dictationTheme.typography.h1)
    }
}

@Preview
@Composable
fun ScorePreview() {
    DictationTheme {
        Score(score = 26)
    }
}