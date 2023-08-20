package com.example.dictation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.PageInitialNotLoaded
import com.example.dictation.base.PaginationLoadableData
import com.example.dictation.base.toLoaded
import com.example.dictation.base.toLoading
import com.example.dictation.domain.usecase.InsertWordsUseCase
import com.example.dictation.domain.usecase.IsFirstTimeUsingUseCase
import com.example.dictation.presentation.navigation.MainNavGraph
import com.example.dictation.presentation.ui.TestList
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
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
            DictationTheme {
                val navController = rememberAnimatedNavController()

                val alphabets = ('A'..'Z').toMutableList()
                val shuffAlp = alphabets.shuffled()
                val state = MutableStateFlow<PaginationLoadableData<List<Char>>>(
                    PageInitialNotLoaded(
                        1,
                        10
                    )
                )

                LaunchedEffect(key1 = alphabets) {
                    val paginated = PageInitialNotLoaded(1, 10)
                    state.update {
                        paginated
                    }
                    delay(1000)
                    state.update {
                        paginated.toLoading()
                    }
                    delay(2000)
                    state.update {
                        paginated.toLoaded(
                            data = shuffAlp,
                            addedCount = 26,
                            hasMorePages = true,
                            page = 1
                        )
                    }
                }

                TestList(paginated = state.collectAsState().value) {
                    //load more
                }

                //  MainNavGraph(navController = navController)
            }
        }
    }
}