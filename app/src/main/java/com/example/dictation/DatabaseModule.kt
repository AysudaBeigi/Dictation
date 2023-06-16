package com.example.dictation

import android.app.Application
import androidx.room.Room
import com.example.dictation.data.DictationDatabase
import com.example.dictation.data.UserDao
import com.example.dictation.data.WordsDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): DictationDatabase {
        return Room.databaseBuilder(application, DictationDatabase::class.java, "dictation")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideWordsDao(database: DictationDatabase): WordsDao {
        return database.wordsDao
    }
    fun provideUserDao(database: DictationDatabase): UserDao {
        return database.userDao
    }

    single { provideDatabase(androidApplication()) }

    single { provideWordsDao(get()) }
    single { provideUserDao(get()) }

}