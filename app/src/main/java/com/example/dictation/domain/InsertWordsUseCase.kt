package com.example.dictation.domain

class InsertWordsUseCase(private val repository: Repository) {
    suspend fun execute() {
        repository.insertWords(listOf(Word("hello",Level.EASY)))
    }
}