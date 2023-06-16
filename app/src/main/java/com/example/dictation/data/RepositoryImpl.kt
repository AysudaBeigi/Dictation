package com.example.dictation.data

import com.example.dictation.domain.Level
import com.example.dictation.domain.Repository
import com.example.dictation.domain.User
import com.example.dictation.domain.Word
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RepositoryImpl(private val wordsDao: WordsDao, private val userDao: UserDao) : Repository {
    private val userFlow:MutableStateFlow<User?> = MutableStateFlow(null)
    override suspend fun insertWords(words: List<Word>) {
        wordsDao.insertOrUpdateAll(words)
    }

    override suspend fun getSelectedLevelWords(level: Level): List<Word> {
        return wordsDao.getSelectedLevelWords(level)
    }

    override suspend fun getUser(): StateFlow<User?> {
        userFlow.value = userDao.getUser()
        return userFlow.asStateFlow()
    }

    override suspend fun insertOrUpdateUser(user: User) {
        userDao.insertOrUpdateUser(user = user)
        userFlow.emit(user)
    }
}