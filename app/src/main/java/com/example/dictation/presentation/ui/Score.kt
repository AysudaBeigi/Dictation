package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
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
        ScoreAmount(
            modifier = Modifier
                .padding(vertical = 72.dp, horizontal = 16.dp)
                .align(Alignment.BottomCenter),
            score = score
        )
        ShowAnimation(modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Composable
private fun ScoreAmount(score: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = dictationTheme.shapes.large,
        backgroundColor = dictationTheme.colors.pink,
        elevation = 4.dp
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Space(size = 16.dp)
            Text(
                text = stringResource(id = R.string.score_title),
                style = dictationTheme.typography.h1.copy(fontWeight = FontWeight.Normal),
                color = dictationTheme.colors.primary
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = score.toString(),
                style = dictationTheme.typography.subtitle1,
                modifier = Modifier,
                color = dictationTheme.colors.yellow,
                textAlign = TextAlign.Center,
            )
            Space(size = 16.dp)
        }
    }
}

@Composable
private fun ShowAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_star_2))
    val animationState by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = animationState,
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