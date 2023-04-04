package com.example.dictation.domain

import androidx.room.Entity

@Entity(tableName = "word")
data class Word(
    val name: String,

    )