package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.Failed
import com.example.dictation.base.LoadableData
import com.example.dictation.base.Loaded
import com.example.dictation.base.Loading
import com.example.dictation.base.NotLoaded
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.Space
import com.example.dictation.domain.Level
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
            LoadedWords(words, modifier, increaseScore, onReadWordClicked, score)
        }

        is Failed -> {
            Text(text = "failed !!!! ")
        }
    }
}

@Composable
private fun LoadedWords(
    words: Loaded<List<Word>>,
    modifier: Modifier,
    increaseScore: () -> Unit,
    onReadWordClicked: (String) -> Unit,
    score: Int
) {
    val state = rememberLazyListState()
    if (words.data.isEmpty()) {
        //todo: show empty words ui
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = dictationTheme.colors.background)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.enter_word),
                textAlign = TextAlign.Center,
                style = dictationTheme.typography.h1,
                modifier = Modifier
                    .align(TopCenter)
                    .padding(16.dp),
                color = dictationTheme.colors.primary,
            )
            WordsLazyRow(
                modifier.align(Center),
                state,
                words,
                increaseScore,
                onReadWordClicked
            )
            WordsTotalScore(score = score, modifier = Modifier
                .align(BottomCenter)
                .padding(16.dp))
        }
    }
}

@Composable
private fun WordsTotalScore(score: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.score),
            style = dictationTheme.typography.h2,
        )
        Space(size = 16.dp)
        Text(text = score.toString(), style = dictationTheme.typography.h2)
    }
}

@Composable
private fun WordsLazyRow(
    modifier: Modifier,
    state: LazyListState,
    words: Loaded<List<Word>>,
    increaseScore: () -> Unit,
    onReadWordClicked: (String) -> Unit
) {
    LazyRow(
        modifier = modifier,
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
}

@Preview
@Composable
fun WordsScreenPreview() {
    DictationTheme {
        WordsScreen(
            increaseScore = { /*TODO*/ },
            onReadWordClicked = { /*TODO*/ },
            words = Loaded(listOf(Word("eye", Level.EASY), Word("hand", Level.EASY))),
            score = 56
        )
    }
}