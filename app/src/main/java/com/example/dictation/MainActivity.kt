package com.example.dictation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.example.dictation.presentation.TTS

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val aSwitch = findViewById<Switch>(R.id.switch1)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener { TTS(this@MainActivity, editText.text.toString(), aSwitch.isChecked) }
    }


}