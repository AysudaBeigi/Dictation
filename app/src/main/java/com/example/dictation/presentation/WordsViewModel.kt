//package com.example.dictation.presentation
//
//import android.content.Context
//import android.speech.tts.TextToSpeech
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import com.example.dictation.base.BaseViewModel
//import java.util.Locale
//
//
//class WordsViewModel() : BaseViewModel() {
//    private var tts: TextToSpeech? = null
//    private var btnSpeak: Button? = null
//    private var etSpeak: EditText? = null
//
//    init {
//        tts = TextToSpeech(this, this)
//
//    }
//
//    private fun speakOut() {
//        val text = etSpeak!!.text.toString()
//        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
//    }
//
//    fun onInit(status: Int) {
//        // TextToSpeech(Context: this, OnInitListener: this)
//        if (status == TextToSpeech.SUCCESS) {
//            val result = tts!!.setLanguage(Locale.US)
//
//            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                Log.e("TTS", "The Language not supported!")
//            } else {
//                btnSpeak!!.isEnabled = true
//            }
//        }
//
//    }
//
//    fun onDestroy() {
//        if (tts != null) {
//            tts!!.stop()
//            tts!!.shutdown()
//        }
//    }
//
//}