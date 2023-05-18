package com.example.dictation.domain

interface Repository {
   suspend fun insertWords(words:List<Word>)
}