package com.example.dictation.data

data class WordDto(
    val name:String,
    val level:LevelDto
)
data class UserDto(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val scoreDto: ScoreDto
)
enum class LevelDto {
    EASY, HARD, MIDDLE
}

data class ScoreDto(
    val amount: Int
)