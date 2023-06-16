package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme

@Composable
fun WordScreen(
    modifier: Modifier = Modifier,
    word: String,
    increaseScore: () -> Unit,
    onReadWordClicked: () -> Unit,
) {
    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    val backgroundColor = remember {
        mutableStateOf(dictationTheme.colors.pink)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor.value, shape = dictationTheme.shapes.medium)
            .padding(16.dp)
    ) {

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
                        .size(120.dp)
                )
            }

            Spacer(modifier = Modifier.size(32.dp))
            OutlinedTextField(value = inputValue.value, onValueChange = { inputValue.value = it })
            Spacer(modifier = Modifier.size(32.dp))
            Button(
                onClick = {
                    if (inputValue.value.text.trim() == word) {
                        increaseScore()
                        backgroundColor.value = dictationTheme.colors.darkGreen
                        //todo: success animation
                    } else {
                        backgroundColor.value = dictationTheme.colors.darkRed
                        //todo: failed animation
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = dictationTheme.colors.pink,
                        shape = dictationTheme.shapes.medium
                    )
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }

}

@Preview
@Composable
fun WordScreenPreview() {
    DictationTheme {
        WordScreen(
            increaseScore = { /*TODO*/ },
            onReadWordClicked = { /*TODO*/ },
            word = "hello"
        )
    }
}