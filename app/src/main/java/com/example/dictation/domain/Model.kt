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

data class Score(
    val amount: Int,
)

@Entity(tableName = "user")
data class User(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val score: Score,
)