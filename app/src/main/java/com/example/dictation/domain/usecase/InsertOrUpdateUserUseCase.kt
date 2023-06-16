package com.example.dictation.domain.usecase

import com.example.dictation.domain.Repository
import com.example.dictation.domain.User

class InsertOrUpdateUserUseCase(private val repository: Repository) {
    suspend fun execute(user: User) {
        repository.insertOrUpdateUser(user = user)
    }
}