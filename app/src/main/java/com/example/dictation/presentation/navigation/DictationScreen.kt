package com.example.dictation.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dictation.base.dictationTheme
import com.example.dictation.presentation.WordsViewModel
import com.example.dictation.presentation.ui.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun DictationScreen(
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val viewModel: WordsViewModel = getViewModel()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            DictationTopBar(scope, scaffoldState)
        },
        drawerContent = {
            Drawer(onProfileClicked = {
                navController.navigate(
                    DictationNavigation.Profile.navigationName()
                )
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }, onScoreClicked = {
                navController.navigate(DictationNavigation.Score.navigationName())
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }, onLogoutClicked = {
                viewModel.deleteUser()
                navController.navigate(DictationNavigation.Profile.navigationName())
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }, onHomeClicked = {
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navController.navigate(DictationNavigation.SelectLevel.navigationName())
            })
        },
    ) { padding ->
        Box(modifier = Modifier.padding()) {
            DictationGraph(navController = navController, viewModel = viewModel)
        }
    }
}

@Composable
private fun DictationTopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Menu,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }, tint = dictationTheme.colors.pink, contentDescription = null
            )
        }, title = {}, backgroundColor = dictationTheme.colors.background
    )
}

@Composable
fun DictationGraph(navController: NavHostController, viewModel: WordsViewModel) {

    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current

    val startDestination =
        if (viewModel.isFirstTimeUsing()) DictationNavigation.Profile.navigationName() else
            DictationNavigation.SelectLevel.navigationName()

    NavHost(
        navController = navController,
        startDestination = startDestination
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
        composable(DictationNavigation.Score.navigationName()) {
            Score(score = state.score)
        }
    }
}