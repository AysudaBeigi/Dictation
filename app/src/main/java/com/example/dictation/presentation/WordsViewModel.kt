package com.example.dictation.presentation

import com.example.dictation.base.BaseViewModel
import com.example.dictation.base.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

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
    coroutineDispatcherProvider: CoroutineDispatcherProvider = coroutineDispatcherProvider()) :
    BaseViewModel(coroutineContexts = coroutineDispatcherProvider) {

    init {

    }

//    fun onReadWordClicked(){
//        TTS(,"Hi baby", false)
//    }
}