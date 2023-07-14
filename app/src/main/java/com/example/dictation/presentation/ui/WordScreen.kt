package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.PrimaryButton
import com.example.dictation.domain.DictationResult

@Composable
fun WordScreen(
    modifier: Modifier = Modifier,
    word: String,
    sendResult: (DictationResult) -> Unit,
    onReadWordClicked: () -> Unit,
) {
    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    val backgroundColor = remember {
        mutableStateOf(dictationTheme.colors.background)
    }
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(color = backgroundColor.value, shape = dictationTheme.shapes.medium)
            .border(
                width = 2.dp,
                color = dictationTheme.colors.primary,
                shape = dictationTheme.shapes.medium
            )
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { onReadWordClicked() }, modifier = Modifier.size(126.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play_2),
                contentDescription = stringResource(id = R.string.read_word),
                modifier = Modifier
                    .size(100.dp), tint = dictationTheme.colors.pink
            )
        }

        Spacer(modifier = Modifier.size(32.dp))
        OutlinedTextField(
            value = inputValue.value,
            onValueChange = { inputValue.value = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor = dictationTheme.colors.primary),
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = dictationTheme.colors.primary,
                    shape = dictationTheme.shapes.large
                )
                .width(260.dp), shape = dictationTheme.shapes.large
        )
        Spacer(modifier = Modifier.size(32.dp))
        val previousInputValue = remember {
            mutableStateOf("")
        }
        PrimaryButton(
            onClick = {
                if (inputValue.value.text.trim() != previousInputValue.value) {
                    previousInputValue.value = inputValue.value.text.trim()
                    showResult(inputValue, word, sendResult, backgroundColor)
                }

            }, title = stringResource(id = R.string.submit),
            modifier = Modifier.fillMaxWidth()
        )

    }
}

private fun showResult(
    inputValue: MutableState<TextFieldValue>,
    word: String,
    sendResult: (DictationResult) -> Unit,
    backgroundColor: MutableState<Color>
) {
    if (inputValue.value.text.trim().equals(word, ignoreCase = true)) {
        sendResult(DictationResult.Success)
        backgroundColor.value = dictationTheme.colors.darkGreen
    } else {
        sendResult(DictationResult.Failed)
        backgroundColor.value = dictationTheme.colors.darkRed
    }
}

@Preview
@Composable
fun WordScreenPreview() {
    DictationTheme {
        WordScreen(
            sendResult = { /*TODO*/ },
            onReadWordClicked = { /*TODO*/ },
            word = "hello"
        )
    }
}