package com.example.dictation.data


import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

@ProvidedTypeConverter
class WordEntityConverter {
    private val json = Json(builderAction = {
        ignoreUnknownKeys = true
    })

    @OptIn(InternalSerializationApi::class)
    @TypeConverter
    fun wordsDtoToString(words: List<WordDto>?): String? {
        if (words == null)
            return null
        return json.encodeToString(ListSerializer(WordDto::class.serializer()), words)
    }

    @OptIn(InternalSerializationApi::class)
    @TypeConverter
    fun stringToWords(words: String?): List<WordDto>? {
        if (words == null)
            return null
        return Json.decodeFromString(ListSerializer(WordDto::class.serializer()), words)
    }
}