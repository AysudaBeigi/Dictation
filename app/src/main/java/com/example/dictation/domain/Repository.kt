package com.example.dictation.domain

interface Repository {
    fun insertWords(words:List<Word>)
}