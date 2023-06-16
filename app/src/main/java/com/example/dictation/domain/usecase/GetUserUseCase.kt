package com.example.dictation.domain.usecase

import com.example.dictation.domain.Repository
import com.example.dictation.domain.User
import kotlinx.coroutines.flow.StateFlow

class GetUserUseCase(private val repository: Repository) {
    suspend fun execute(): StateFlow<User?> {
      return  repository.getUser()
    }
}