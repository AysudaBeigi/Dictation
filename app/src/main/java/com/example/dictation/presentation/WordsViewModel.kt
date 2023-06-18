package com.example.dictation.presentation

import android.content.Context
import android.util.Log
import com.example.dictation.base.*
import com.example.dictation.domain.Level
import com.example.dictation.domain.User
import com.example.dictation.domain.Word
import com.example.dictation.domain.usecase.GetIsFirstTimeUsingUseCase
import com.example.dictation.domain.usecase.GetSelectedLevelWordsUseCase
import com.example.dictation.domain.usecase.GetUserUseCase
import com.example.dictation.domain.usecase.InsertOrUpdateUserUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun coroutineDispatcherProvider() = object : CoroutineDispatcherProvider {
    override fun bgDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    override fun ioDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun uiDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun immediateDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main.immediate
    }
}

class WordsViewModel(
    private val getSelectedLevelWordsUseCase: GetSelectedLevelWordsUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val insertOrUpdateUserUseCase: InsertOrUpdateUserUseCase,
    private val isFirstTimeUsing: GetIsFirstTimeUsingUseCase,
    coroutineDispatcherProvider: CoroutineDispatcherProvider = coroutineDispatcherProvider()
) :
    DictationViewModel<WordsViewModel.State>(
        initialState = State(),
        coroutineDispatcherProvider = coroutineDispatcherProvider
    ) {
    data class State(
        val LoadableWords: LoadableData<List<Word>> = NotLoaded,
        val level: Level = Level.EASY,
        val score: Int = 0,
        val user: LoadableData<User?> = NotLoaded,
    )

    init {
        getSelectedLevelWordsUseCase(state.value.level)
        getUser()
    }

    fun isFirstTimeUsing() = isFirstTimeUsing.execute()
    private fun getSelectedLevelWordsUseCase(level: Level) {
        applyState {
            copy(LoadableWords = Loading)
        }

        launch {
            runCatching {
                getSelectedLevelWordsUseCase.execute(level = level)
            }.fold(
                onSuccess = { words ->
                    applyState {
                        copy(LoadableWords = Loaded(words))
                    }
                },
                onFailure = {
                    applyState {
                        copy(LoadableWords = NotLoaded)
                    }
                    Log.d("TAG", "can not read words")

                }
            )
        }
    }


    fun onReadWordClicked(word: String, context: Context) {
        TTS(word = word, context = context)
    }

    fun increaseScore() {
        applyState {
            copy(score = score + 1)
        }
    }

    fun selectLevel(level: Level) {
        applyState {
            copy(level = level)
        }
    }

    private fun getUser() {
        applyState {
            copy(user = Loading)
        }
        launch {
            runCatching {
                getUserUseCase.execute().collect {
                    applyState {
                        copy(user = Loaded(it))
                    }
                }
            }.onFailure {
                Log.d("TAG", "getUser: failed $it")
            }
        }
    }

    fun saveUser(firstName: String, lastName: String, phoneNumber: String) {
        launch {
            insertOrUpdateUserUseCase.execute(
                User(
                    firstName = firstName,
                    lastName = lastName,
                    phoneNumber = phoneNumber,
                    score = state.value.score
                )
            )
        }
    }
}