package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dictation.domain.Word

@Composable
fun WordsScreen(words: List<Word>, modifier: Modifier = Modifier) {
    val state = rememberLazyListState()
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        state = state, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(words) { word ->
            WordItem(
               word
            )
        }
    }
}

@Composable
fun WordItem(word: Word, modifier: Modifier = Modifier) {
    Row(modifier) {
        Text(text = word.name)

    }
}