package com.example.dictation.presentation.ui

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dictation.domain.Word

@Composable
fun WordsScreen(
    modifier: Modifier = Modifier,
    words: List<Word>?,
    score: Int,
    increaseScore: () -> Unit,
    onReadWordClicked: (String) -> Unit,
) {
    words?.let {
        val state = rememberLazyListState()
        LazyRow(modifier = modifier, state = state) {
            items(words) { word ->
                WordScreen(
                    score = score,
                    word = word.name,
                    increaseScore = increaseScore,
                    onReadWordClicked = { onReadWordClicked(word.name) },
                    onNextClicked = { /*TODO*/ })
            }
        }
    } ?: run {
        Text(text = "empty words ")
        //todo: show empty words ui
    }


}