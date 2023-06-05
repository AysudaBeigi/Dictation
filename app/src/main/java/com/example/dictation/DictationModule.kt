package com.example.dictation

import com.example.dictation.data.DictationPreferences
import com.example.dictation.data.RepositoryImpl
import com.example.dictation.domain.Repository
import com.example.dictation.domain.usecase.GetSelectedLevelWordsUseCase
import com.example.dictation.domain.usecase.InsertWordsUseCase
import com.example.dictation.presentation.WordsViewModel
import com.example.dictation.presentation.coroutineDispatcherProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dictationModule = module {
    single<Repository> {
        RepositoryImpl(wordsDao = get())
    }
    factory {
        InsertWordsUseCase(repository = get())
    }
    factory {
        GetSelectedLevelWordsUseCase(repository = get())
    }
    viewModel {
        WordsViewModel(
            coroutineDispatcherProvider = coroutineDispatcherProvider(),
            getSelectedLevelWordsUseCase = get()
        )
    }
    single {
        DictationPreferences(androidApplication())
    }

}