package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationColor
import com.example.dictation.base.dictationTheme
import com.example.dictation.domain.Level

@Composable
fun DictationLevelScreen(
    onLevelClicked: (level: String) -> Unit, modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .background(color = dictationTheme.colors.background)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.select_dictation_level),
            modifier = Modifier
                .padding(vertical = 64.dp)
                .align(Alignment.TopCenter),
            textAlign = TextAlign.Center,
            style = dictationTheme.typography.h1
        )

        Column(
            modifier = modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.size(32.dp))
            DictationLevel(
                level = Level.EASY.toString(),
                color = dictationTheme.colors.yellow,
                onLevelClicked
            )
            Spacer(modifier = Modifier.size(16.dp))
            DictationLevel(
                level = Level.MIDDLE.toString(),
                color = dictationTheme.colors.lightGreen,
                onLevelClicked
            )
            Spacer(modifier = Modifier.size(16.dp))
            DictationLevel(
                level = Level.HARD.toString(),
                color = dictationTheme.colors.pink,
                onLevelClicked
            )
        }
    }

}

@Composable
fun DictationLevel(level: String, color: Color, onLevelClicked: (level: String) -> Unit) {
    Row(
        modifier = Modifier
            .background(color = color, shape = dictationTheme.shapes.medium)
            .fillMaxWidth()
            .height(64.dp)
            .clickable {
                onLevelClicked(level)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = level, modifier = Modifier)
    }
}

@Preview
@Composable
fun DictationLevelScreenPreview() {
    DictationTheme {
        DictationLevelScreen(onLevelClicked = {})
    }
}