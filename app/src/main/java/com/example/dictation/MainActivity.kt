package com.example.dictation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dictation.domain.usecase.GetIsFirstTimeUsingUseCase
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
        getIsFirstTimeUsingUseCase: GetIsFirstTimeUsingUseCase,
        insertWordsUseCase: InsertWordsUseCase
    ) {
        lifecycleScope.launch {
            if (getIsFirstTimeUsingUseCase.execute()) {
                insertWordsUseCase.execute()
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val getIsFirstTimeUsingUseCase: GetIsFirstTimeUsingUseCase by inject()
        val insertWordsUseCase: InsertWordsUseCase by inject()
        uploadWords(getIsFirstTimeUsingUseCase, insertWordsUseCase)
        setContent {
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
                    }, onScoreClicked = {
                        navController.navigate(DictationNavigation.Score.navigationName())
                    })
                }
            ) {
                DictationNavGraph(navController = navController)
            }
        }
    }
}