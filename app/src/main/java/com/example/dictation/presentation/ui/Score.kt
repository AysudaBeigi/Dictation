package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.Space

@Composable
fun Score(modifier: Modifier = Modifier, score: Int) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = dictationTheme.colors.background)
    ) {
        ScoreContent(Modifier.align(Alignment.TopCenter), score)
        ShowAnimation(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun ScoreContent(modifier: Modifier = Modifier, score: Int) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Space(size = 64.dp)
        Text(
            text = stringResource(id = R.string.score_title),
            style = dictationTheme.typography.h1
        )
        Space(size = 32.dp)
        Text(text = score.toString(), style = dictationTheme.typography.h1)

    }
}

@Composable
private fun ShowAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.score))
    val animationState = animateLottieCompositionAsState(composition = composition)

    LottieAnimation(
        composition = composition,
        progress = animationState.progress,
        modifier = modifier,
    )
}

@Preview
@Composable
fun ScorePreview() {
    DictationTheme {
        Score(score = 26)
    }
}