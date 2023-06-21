package com.example.dictation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.example.dictation.domain.usecase.IsFirstTimeUsingUseCase
import com.example.dictation.domain.usecase.InsertWordsUseCase
import com.example.dictation.presentation.navigation.MainNavGraph
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

    @OptIn(ExperimentalAnimationApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isFirstTimeUsingUseCase: IsFirstTimeUsingUseCase by inject()
        val insertWordsUseCase: InsertWordsUseCase by inject()
        uploadWords(isFirstTimeUsingUseCase, insertWordsUseCase)
        setContent {
            val navController = rememberAnimatedNavController()
            MainNavGraph(navController = navController)
        }
    }
}