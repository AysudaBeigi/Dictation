package com.example.dictation

import android.app.Application
import androidx.room.Room
import com.example.dictation.data.DictationDatabase
import com.example.dictation.data.WordEntityConverter
import com.example.dictation.data.WordsDao
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): DictationDatabase {
        return Room.databaseBuilder(application, DictationDatabase::class.java, "dictation")
            .fallbackToDestructiveMigration()
            .addTypeConverter(WordEntityConverter())
            .build()
    }

    fun providePlacesDao(database: DictationDatabase): WordsDao {
        return database.wordsDao
    }

}