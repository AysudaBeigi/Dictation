package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.*
import com.example.dictation.core.Space
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.enter_word),
                        textAlign = TextAlign.Center,
                        style = dictationTheme.typography.h1,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Center)
                    )
                    LazyRow(
                        modifier = modifier
                            .align(Center),
                        state = state
                    ) {
                        items(words.data) { word ->
                            WordScreen(
                                word = word.name,
                                increaseScore = increaseScore,
                                onReadWordClicked = { onReadWordClicked(word.name) },
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .align(BottomCenter)
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.score),
                            style = dictationTheme.typography.h2,
                        )
                        Space(size = 16.dp)
                        Text(text = score.toString(), style = dictationTheme.typography.h2)
                    }
                }
            }

        }
        is Failed -> {
            Text(text = "failed !!!! ")
        }
    }
}

@Preview
@Composable
fun WordsScreenPreview() {
    DictationTheme {
        WordsScreen(
            increaseScore = { /*TODO*/ },
            onReadWordClicked = { /*TODO*/ },
            words = Loaded(listOf()),
            score = 56
        )
    }
}