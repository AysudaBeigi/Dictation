package com.example.dictation.presentation


import android.content.Context
import android.speech.tts.TextToSpeech
import android.widget.Toast
import java.util.*

class TTS(
    private val context: Context,
    private val word: String
) : TextToSpeech.OnInitListener {

    private val tts: TextToSpeech = TextToSpeech(context, this)

    override fun onInit(i: Int) {
        if (i == TextToSpeech.SUCCESS) {
            val localeUS = Locale.US

            val result: Int = tts.setLanguage(localeUS)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(context, "This Language is not supported", Toast.LENGTH_SHORT)
                    .show()
            } else {
                speakOut(word)
            }

        } else {
            Toast.makeText(context, "Initilization Failed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun speakOut(message: String) {
        tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}