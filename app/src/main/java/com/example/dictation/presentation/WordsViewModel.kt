package com.example.dictation.presentation

import android.content.Context
import android.util.Log
import com.example.dictation.base.BaseViewModel
import com.example.dictation.base.CoroutineDispatcherProvider
import com.example.dictation.domain.Level
import com.example.dictation.domain.Word
import com.example.dictation.domain.usecase.GetSelectedLevelWordsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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
    BaseViewModel(coroutineContexts = coroutineDispatcherProvider) {
    private val _state: MutableStateFlow<State?> = MutableStateFlow(null)
    val state: StateFlow<State?> = _state

    init {
        getSelectedLevelWordsUseCase(_state.value?.level?:Level.EASY)
    }

    private fun getSelectedLevelWordsUseCase(level: Level) {
        launch {
            runCatching {
                getSelectedLevelWordsUseCase.execute(level = level)
            }.fold(
                onSuccess = { words ->
                    _state.update {
                        it?.copy(words = words)
                    }
                },
                onFailure = {
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
        _state.update {
            it?.copy(level = level)
        }
    }
}