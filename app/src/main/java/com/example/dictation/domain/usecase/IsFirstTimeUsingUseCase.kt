package com.example.dictation.domain.usecase

import com.example.dictation.data.DictationPreferences

class IsFirstTimeUsingUseCase(private val dictationPreferences: DictationPreferences) {
    fun execute()=  dictationPreferences.isFirstTimeUsing

    fun updatePreferences(){
        dictationPreferences.isFirstTimeUsing = false
    }
}