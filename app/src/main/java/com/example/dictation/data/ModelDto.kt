package com.example.dictation.data

import kotlinx.serialization.Serializable

data class WordDto(
    val name:String,
    val level:LevelDto
)
@Serializable
data class UserDto(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val scoreDto: Int
)
enum class LevelDto {
    EASY, HARD, MIDDLE
}
