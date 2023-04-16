package com.example.dictation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.dictation.presentation.TTS
import com.example.dictation.presentation.ui.WordScreen

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var color = remember{
                mutableStateOf(Color.White)
            }
            WordScreen(
                score = 12,
                onSubmitClicked = {
                          if(it=="Hi baby")   color.value = Color.Green else color.value = Color.Red
                },
                onReadWordClicked = { TTS(this@MainActivity,"Hi baby", false)},
                onNextClicked = { /*TODO*/ }, modifier = Modifier.background(color = color.value))

        }
    }


}