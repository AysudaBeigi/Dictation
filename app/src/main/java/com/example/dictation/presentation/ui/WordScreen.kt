package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme

@Composable
fun WordScreen(
    modifier: Modifier = Modifier,
    score: Int,
    word: String,
    increaseScore: () -> Unit,
    onReadWordClicked: () -> Unit,
    onNextClicked: () -> Unit,
) {
    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.align(Alignment.TopEnd)) {
            Text(text = stringResource(id = R.string.score))
            Text(text = score.toString())
        }
        Column(
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = { onReadWordClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = stringResource(id = R.string.read_word),
                    modifier = modifier
                        .size(250.dp)
                )
            }

            Spacer(modifier = Modifier.size(32.dp))
            OutlinedTextField(value = inputValue.value, onValueChange = { inputValue.value = it })
            Spacer(modifier = Modifier.size(32.dp))
            Button(
                onClick = {
                    if (inputValue.value.text.trim() == word) {
                        increaseScore()
                        //todo: success animation
                    } else {
                        //todo: failed animation
                    }

                },
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
        IconButton(onClick = onNextClicked, modifier = Modifier.align(Alignment.BottomEnd)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = stringResource(
                    id = R.string.next
                ), modifier = Modifier.size(48.dp)
            )
        }
    }

}

@Preview
@Composable
fun WordScreenPreview() {
    DictationTheme {
        WordScreen(
            score = 12,
            increaseScore = { /*TODO*/ },
            onReadWordClicked = { /*TODO*/ },
            onNextClicked = { /*TODO*/ }, word = "hello"
        )
    }
}