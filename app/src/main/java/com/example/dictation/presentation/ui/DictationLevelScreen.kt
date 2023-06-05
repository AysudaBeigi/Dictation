package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme
import com.example.dictation.domain.Level

@Composable
fun DictationLevelScreen(
    modifier: Modifier = Modifier,
    onLevelClicked: (level: Level) -> Unit,
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
                level = Level.EASY,
                color = dictationTheme.colors.yellow,
                onLevelClicked
            )
            Spacer(modifier = Modifier.size(16.dp))
            DictationLevel(
                level = Level.MIDDLE,
                color = dictationTheme.colors.lightGreen,
                onLevelClicked
            )
            Spacer(modifier = Modifier.size(16.dp))
            DictationLevel(
                level = Level.HARD,
                color = dictationTheme.colors.pink,
                onLevelClicked
            )
        }
    }

}

@Composable
fun DictationLevel(level: Level, color: Color, onLevelClicked: (level: Level) -> Unit) {
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
        Text(text = level.toString(), modifier = Modifier)
    }
}

@Preview
@Composable
fun DictationLevelScreenPreview() {
    DictationTheme {
        DictationLevelScreen(onLevelClicked = {})
    }
}