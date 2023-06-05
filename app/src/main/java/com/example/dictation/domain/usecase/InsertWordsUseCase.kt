package com.example.dictation.domain.usecase

import com.example.dictation.domain.Level
import com.example.dictation.domain.Repository
import com.example.dictation.domain.Word

class InsertWordsUseCase(private val repository: Repository) {
    suspend fun execute() {
        repository.insertWords(
            listOf(
                Word("hello", Level.EASY),
                Word("face", Level.EASY),
                Word("eye", Level.EASY),
                Word("arm", Level.EASY),
                Word("hand", Level.EASY),
                Word("leg", Level.EASY),
                Word("hello", Level.EASY),
                Word("hello", Level.EASY),
                Word("hello", Level.EASY),
                Word("hello", Level.EASY),
                Word("hello", Level.EASY),
                Word("hello", Level.EASY),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.MIDDLE),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
                Word("hello", Level.HARD),
            )
        )
    }
}