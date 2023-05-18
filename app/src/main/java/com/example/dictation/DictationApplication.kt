package com.example.dictation

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class DictationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
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