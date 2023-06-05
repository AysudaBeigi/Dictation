package com.example.dictation.domain.usecase

import com.example.dictation.domain.Level
import com.example.dictation.domain.Repository
import com.example.dictation.domain.Word

class GetSelectedLevelWordsUseCase(private val repository: Repository){
    suspend fun execute(level: Level):List<Word>{
      return  repository.getSelectedLevelWords(level)
    }
}