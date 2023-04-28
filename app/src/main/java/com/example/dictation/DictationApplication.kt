package com.example.dictation

import android.app.Application
import com.example.dictation.data.DictationPreferences
import com.example.dictation.domain.InsertWordsUseCase
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class DictationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val dictationPreferences: DictationPreferences by inject()
        val insertWordsUseCase:InsertWordsUseCase by inject()
        uploadWords(dictationPreferences, insertWordsUseCase)
        startKoin()
    }

    private fun uploadWords(
        dictationPreferences: DictationPreferences,
        insertWordsUseCase: InsertWordsUseCase
    ) {
        if (dictationPreferences.isFirstTimeUsing) {
            insertWordsUseCase.execute()
        }
    }

    private fun startKoin() {
        GlobalContext.startKoin {
            androidContext(this@DictationApplication)
            modules(
                listOf(
                    dictationModule,
                    databaseModule,
                )
            )
        }
    }
}