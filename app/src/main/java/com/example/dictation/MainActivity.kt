package com.example.dictation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.dictation.domain.usecase.GetIsFirstTimeUsingUseCase
import com.example.dictation.domain.usecase.InsertWordsUseCase
import com.example.dictation.presentation.navigation.DictationNavGraph
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val getIsFirstTimeUsingUseCase: GetIsFirstTimeUsingUseCase by inject()
        val insertWordsUseCase: InsertWordsUseCase by inject()
        uploadWords(getIsFirstTimeUsingUseCase, insertWordsUseCase)
        setContent {
            DictationNavGraph()
        }
    }


}