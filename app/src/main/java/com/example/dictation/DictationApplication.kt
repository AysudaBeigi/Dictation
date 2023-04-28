package com.example.dictation

import android.app.Application
import com.example.dictation.data.DictationPreferences
import org.koin.android.ext.android.inject

class DictationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val dictationPreferences: DictationPreferences by inject()
        uploadWords(dictationPreferences)
    }

    private fun uploadWords(dictationPreferences: DictationPreferences) {
        if (dictationPreferences.isFirstTimeUsing) {
            //todo: upload words into room

        }
    }
}