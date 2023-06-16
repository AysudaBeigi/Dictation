package com.example.dictation.presentation

import android.content.Context
import android.util.Log
import com.example.dictation.base.*
import com.example.dictation.domain.Level
import com.example.dictation.domain.Word
import com.example.dictation.domain.usecase.GetSelectedLevelWordsUseCase
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

data class State(
    val level: Level,
    val words: List<Word>,
    val score: Int,
)

class WordsViewModel(
    private val getSelectedLevelWordsUseCase: GetSelectedLevelWordsUseCase,
    coroutineDispatcherProvider: CoroutineDispatcherProvider = coroutineDispatcherProvider()
) :
    DictationViewModel<WordsViewModel.State>(
        initialState = State(),
        coroutineDispatcherProvider = coroutineDispatcherProvider
    ) {
    data class State(
        val Loadablewords: LoadableData<List<Word>> = NotLoaded,
        val level: Level = Level.EASY
    )

    init {
        getSelectedLevelWordsUseCase(state.value.level)
    }

    private fun getSelectedLevelWordsUseCase(level: Level) {
        applyState {
            copy(Loadablewords = Loading)
        }

        launch {
            runCatching {
                getSelectedLevelWordsUseCase.execute(level = level)
            }.fold(
                onSuccess = { words ->
                    applyState {
                        copy(Loadablewords = Loaded(words))
                    }
                },
                onFailure = {
                    applyState {
                        copy(Loadablewords = NotLoaded)
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

    }

    fun selectLevel(level: Level) {
        applyState {
            copy(level = level)
        }
    }
}