package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    Box(
        modifier = Modifier
            .background(color = dictationTheme.colors.background)
            .fillMaxSize()
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.dictation_anim))
        val logoAnimationState = animateLottieCompositionAsState(composition = composition)
        LottieAnimation(
            composition = composition,
            progress = logoAnimationState.progress,
            modifier = Modifier.align(Alignment.Center)
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            onFinished()
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    DictationTheme {
        SplashScreen() {}
    }
}