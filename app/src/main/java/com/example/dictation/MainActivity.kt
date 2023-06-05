package com.example.dictation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.dictation.data.DictationPreferences
import com.example.dictation.domain.usecase.InsertWordsUseCase
import com.example.dictation.presentation.navigation.DictationNavGraph
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private fun uploadWords(
        dictationPreferences: DictationPreferences,
        insertWordsUseCase: InsertWordsUseCase
    ) {
        lifecycleScope.launch {
            if (dictationPreferences.isFirstTimeUsing) {
                insertWordsUseCase.execute()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dictationPreferences: DictationPreferences by inject()
        val insertWordsUseCase: InsertWordsUseCase by inject()
        uploadWords(dictationPreferences, insertWordsUseCase)
        setContent {
            DictationNavGraph()
        }
    }


}