package com.example.dictation.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
class UserEntityConverter {
    private val json = Json(builderAction = {
        ignoreUnknownKeys = true
    })

    @TypeConverter
    fun userDtoToString(userDto: UserDto?): String? {
        if (userDto == null)
            return null
        return json.encodeToString(UserDto.serializer(), userDto)
    }

    @TypeConverter
    fun stringToUser(user: String?): UserDto? {
        if (user == null)
            return null
        return Json.decodeFromString(UserDto.serializer(), user)
    }
}