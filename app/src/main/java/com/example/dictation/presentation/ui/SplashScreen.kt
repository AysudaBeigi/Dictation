package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.dictation.R

@Composable
fun SplashScren(modifier: Modifier = Modifier) {
    SplashScreen()
}

// @Composable
// fun SplashScreen(navigateToNextScreen: () -> Unit) {
//     Box(
//         modifier = Modifier.fillMaxSize(),
//         contentAlignment = Alignment.Center
//     ) {
//         val animationSpec = rememberLottieAnimationSpec(
//             repeatCount = Integer.MAX_VALUE
//         )
//         val animationProgress by animateLottieCompositionAsState(
//             composition = LottieCompositionSpec.RawRes(R.raw.dictation_anim),
//             iterations = LottieConstants.IterateForever
//         )
//
//         LaunchedEffect(Unit) {
//             delay(3000) // Delay for the splash screen duration
//             navigateToNextScreen()
//         }
//
//         LottieAnimation(
//             spec = animationSpec,
//             modifier = Modifier.size(300.dp),
//             progress = animationProgress
//         )
//     }
// }
// @Composable
// fun Greeting() {
//     val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.android_logo) }
//     val animationState = rememberLottieAnimationState(autoPlay = true, repeatCount = Integer.MAX_VALUE)
//
//     Column(
//         modifier = Modifier
//             .fillMaxHeight()
//             .fillMaxWidth()
//             .background(Color.White),
//         verticalArrangement = Arrangement.Center
//     ) {
//
//         LottieAnimation(animationSpec,animationState=animationState)
//     }
// }
//
//
// class MainActivity : ComponentActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContent {
//             LottieExample()
//         }
//     }
// }

@Composable
fun SplashScreen() {

    var isPlaying by remember {
        mutableStateOf(true)
    }
    var speed by remember {
        mutableStateOf(1f)
    }
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec
            .RawRes(R.raw.dictation_anim).apply {
                repeat(times = 5, action = {})
            }
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false,
    )

    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(400.dp),
        )
    }
}
