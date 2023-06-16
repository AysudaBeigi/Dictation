package com.example.dictation.domain

import kotlinx.coroutines.flow.StateFlow

interface Repository {
   suspend fun insertWords(words:List<Word>)
   suspend fun getSelectedLevelWords(level: Level):List<Word>
   suspend fun getUser(): StateFlow<User?>
   suspend fun insertOrUpdateUser(user: User)
}