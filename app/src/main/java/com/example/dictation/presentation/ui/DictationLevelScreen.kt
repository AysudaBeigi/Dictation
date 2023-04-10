package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.dictationTheme
import com.example.dictation.domain.Level

@Composable
fun DictationLevelScreen(
    onLevelClicked: (level: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = stringResource(id = R.string.select_dictation_level))
        Spacer(modifier = Modifier.size(32.dp))
        DictationLevel(
            level = Level.EASY.toString(),
            color = dictationTheme.colors.darkGreen,
            onLevelClicked
        )
        Spacer(modifier = Modifier.size(16.dp))
        DictationLevel(
            level = Level.MIDDLE.toString(),
            color = dictationTheme.colors.green,
            onLevelClicked
        )
        Spacer(modifier = Modifier.size(16.dp))
        DictationLevel(
            level = Level.HARD.toString(),
            color = dictationTheme.colors.lightGreen,
            onLevelClicked
        )
    }
}

@Composable
fun DictationLevel(level: String, color: Color, onLevelClicked: (level: String) -> Unit) {
    Row(
        modifier = Modifier
            .background(color = color)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .clickable {
                onLevelClicked(level)
            }
    ) {
        Text(text = level)
    }
}