package com.example.dictation.presentation

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.dictation.base.BaseViewModel
import java.util.Locale


class WordsViewModel () :BaseViewModel() {
    init {

    }

    fun readWord(){
        textToSpeech = TextToSpeech(
            ApplicationProvider.getApplicationContext<Context>()
        ) { i ->
            // if No error is found then only it will run
            if (i != TextToSpeech.ERROR) {
                // To Choose language of speech
                textToSpeech.setLanguage(Locale.UK)
            }
        }
    }
}