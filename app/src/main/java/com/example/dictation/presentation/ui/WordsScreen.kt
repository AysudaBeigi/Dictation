package com.example.dictation.presentation.ui

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dictation.base.*
import com.example.dictation.domain.Word

@Composable
fun WordsScreen(
    modifier: Modifier = Modifier,
    words: LoadableData<List<Word>>,
    score: Int,
    increaseScore: () -> Unit,
    onReadWordClicked: (String) -> Unit,
) {
    when (words) {
        is Loading, NotLoaded -> {

        }
        is Loaded -> {
            val state = rememberLazyListState()
            if (words.data.isEmpty()) {
                //todo: show empty words ui
            } else {
                LazyRow(modifier = modifier, state = state) {
                    items(words.data) { word ->
                        WordScreen(
                            score = score,
                            word = word.name,
                            increaseScore = increaseScore,
                            onReadWordClicked = { onReadWordClicked(word.name) },
                            onNextClicked = { /*TODO*/ })
                    }
                }
            }

        }
        is Failed -> {
            Text(text = "failed !!!! ")
        }
    }
}