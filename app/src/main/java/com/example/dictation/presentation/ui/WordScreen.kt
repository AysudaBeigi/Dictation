package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.dictation.core.PrimaryButton

@Composable
fun WordScreen(
    modifier: Modifier = Modifier,
    word: String,
    increaseScore: () -> Unit,
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
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = stringResource(id = R.string.read_word),
                modifier = Modifier
                    .size(120.dp)
            )
        }

        Spacer(modifier = Modifier.size(32.dp))
        OutlinedTextField(
            value = inputValue.value,
            onValueChange = { inputValue.value = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor = dictationTheme.colors.primary),
            modifier = Modifier.border(
                width = 2.dp,
                color = dictationTheme.colors.primary,
                shape = dictationTheme.shapes.large
            ), shape = dictationTheme.shapes.large
        )
        Spacer(modifier = Modifier.size(32.dp))
        PrimaryButton(
            onClick = {
                if (inputValue.value.text.trim() == word) {
                    increaseScore()
                    backgroundColor.value = dictationTheme.colors.darkGreen
                    //todo: success animation
                } else {
                    backgroundColor.value = dictationTheme.colors.darkRed
                    //todo: failed animation
                }
            }, title = stringResource(id = R.string.submit),
            modifier = Modifier.fillMaxWidth()
        )

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