package com.example.dictation.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
data class Word(
    @PrimaryKey
    val name: String,
    val level: Level
)

enum class Level {
    EASY, HARD, MIDDLE
}

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val score: Int,
)

sealed class DictationResult {
    object Success : DictationResult()
    object Failed : DictationResult()
}