package com.example.dictation.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dictation.base.dictationTheme
import com.example.dictation.presentation.WordsViewModel
import com.example.dictation.presentation.ui.DictationLevelScreen
import com.example.dictation.presentation.ui.WordsScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun DictationNavGraph() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(dictationTheme.colors.background)
    ) {
        val navController = rememberNavController()
        val viewModel: WordsViewModel = getViewModel()
        val state = viewModel.state.collectAsState().value
        val context = LocalContext.current
        NavHost(
            navController = navController,
            startDestination = DictationNavigation.Words.navigationName()
        ) {
            composable(DictationNavigation.Words.navigationName()) {
                WordsScreen(
                    words = state.Loadablewords, score = 12,
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
