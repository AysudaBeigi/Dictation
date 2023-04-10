package com.example.dictation.domain

import androidx.room.Entity

@Entity(tableName = "word")
data class Word(
    val name: String,
    val level: Level
)

enum class Level {
    EASY, HARD, MIDDLE
}
data class Score(
    val amount:Int
)