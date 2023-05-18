package com.example.dictation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import com.example.dictation.data.DictationPreferences
import com.example.dictation.domain.InsertWordsUseCase
import com.example.dictation.presentation.TTS
import com.example.dictation.presentation.ui.WordScreen
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

    @SuppressLint("MissingInflatedId", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dictationPreferences: DictationPreferences by inject()
        val insertWordsUseCase: InsertWordsUseCase by inject()
        uploadWords(dictationPreferences, insertWordsUseCase)
        setContent {
            var color = remember {
                mutableStateOf(Color.White)
            }
            WordScreen(
                score = 12,
                onSubmitClicked = {
                    if (it == "Hi baby") color.value = Color.Green else color.value = Color.Red
                },
                onReadWordClicked = { TTS(this@MainActivity, "Hi baby", false) },
                onNextClicked = {

                }, modifier = Modifier.background(color = color.value)
            )

        }
    }


}