package com.example.dictation.data

import com.example.dictation.domain.Repository
import com.example.dictation.domain.Word

class RepositoryImpl(private val wordsDao: WordsDao) :Repository{
    override suspend fun insertWords(words: List<Word>) {
       wordsDao.insertOrUpdateAll(words)
    }
}