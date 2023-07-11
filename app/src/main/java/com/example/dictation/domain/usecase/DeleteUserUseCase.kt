package com.example.dictation.domain.usecase

import com.example.dictation.domain.Repository
import com.example.dictation.domain.User

class DeleteUserUseCase(private val repository: Repository) {
    suspend fun execute(user: User) {
        repository.deleteUser(user = user)
    }
}