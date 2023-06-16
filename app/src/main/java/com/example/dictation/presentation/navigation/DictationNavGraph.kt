package com.example.dictation.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.composable
import com.example.dictation.base.dictationTheme
import com.example.dictation.presentation.WordsViewModel
import com.example.dictation.presentation.ui.DictationLevelScreen
import com.example.dictation.presentation.ui.ProfileScreen
import com.example.dictation.presentation.ui.WordsScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DictationNavGraph() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(dictationTheme.colors.background)
    ) {
        val navController = rememberAnimatedNavController()
        val viewModel: WordsViewModel = getViewModel()
        val state = viewModel.state.collectAsState().value
        val context = LocalContext.current
        val startDestination =
            if (viewModel.isFirstTimeUsing()) DictationNavigation.Profile.navigationName() else
                DictationNavigation.SelectLevel.navigationName()
        AnimatedNavHost(
            navController = navController,
            startDestination = startDestination,
        ) {

            composable(DictationNavigation.Profile.navigationName()) {
                ProfileScreen(user = state.user) { firstName, lastName, phoneNumber ->
                    viewModel.saveUser(
                        firstName = firstName,
                        lastName = lastName,
                        phoneNumber = phoneNumber
                    )
                    navController.navigate(DictationNavigation.SelectLevel.navigationName())
                }
            }
            composable(DictationNavigation.Words.navigationName()) {
                WordsScreen(
                    words = state.LoadableWords, score = state.score,
                    increaseScore = {
                        viewModel.increaseScore()
                    },
                    onReadWordClicked = { word ->
                        viewModel.onReadWordClicked(word = word, context = context)
                    },
                )
            }
            composable(
                DictationNavigation.SelectLevel.navigationName(),
            ) {
                DictationLevelScreen(onLevelClicked = { level ->
                    viewModel.selectLevel(level = level)
                    navController.navigate(DictationNavigation.Words.navigationName())
                })
            }
        }
    }

}
