package com.example.dictation.domain

class InsertWordsUseCase(private val repository: Repository) {
    fun execute() {
        repository.insertWords(listOf(Word("hello",Level.EASY)))
    }
}