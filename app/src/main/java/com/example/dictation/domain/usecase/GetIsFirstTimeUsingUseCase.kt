package com.example.dictation.domain.usecase

import com.example.dictation.data.DictationPreferences

class GetIsFirstTimeUsingUseCase(private val dictationPreferences: DictationPreferences) {
    fun execute() = dictationPreferences.isFirstTimeUsing
}