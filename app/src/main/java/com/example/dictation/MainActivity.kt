package com.example.dictation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.dictation.domain.usecase.IsFirstTimeUsingUseCase
import com.example.dictation.domain.usecase.InsertWordsUseCase
import com.example.dictation.presentation.navigation.DictationNavGraph
import com.example.dictation.presentation.navigation.DictationNavigation
import com.example.dictation.presentation.ui.Drawer
import com.example.dictation.presentation.ui.TopBar
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private fun uploadWords(
        isFirstTimeUsingUseCase: IsFirstTimeUsingUseCase,
        insertWordsUseCase: InsertWordsUseCase
    ) {
        lifecycleScope.launch {
            if (isFirstTimeUsingUseCase.execute()) {
                insertWordsUseCase.execute()
            }
            isFirstTimeUsingUseCase.updatePreferences()
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isFirstTimeUsingUseCase: IsFirstTimeUsingUseCase by inject()
        val insertWordsUseCase: InsertWordsUseCase by inject()
        uploadWords(isFirstTimeUsingUseCase, insertWordsUseCase)
        setContent {
            DictationMainScreen()
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    @OptIn(ExperimentalAnimationApi::class)
    private fun DictationMainScreen() {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val navController = rememberAnimatedNavController()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            }, drawerContent = {
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
                })
            }
        ) {
            DictationNavGraph(navController = navController)
        }
    }
}