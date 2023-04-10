package com.example.dictation.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.dictation.R

@Composable
fun WordScreen(
    score: Int,
    onSubmitClicked: () -> Unit,
    onReadWordClicked: () -> Unit,
    onNextClicked: () -> Unit,
    modifier: Modifier = Modifier
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
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = stringResource(id = R.string.read_word),
                modifier = modifier.clickable { onReadWordClicked() })
            TextField(value = inputValue.value, onValueChange = { inputValue.value = it })
            Button(onClick = onSubmitClicked, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
        Button(onClick = onNextClicked, modifier = Modifier.align(Alignment.BottomEnd)) {
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = stringResource(
                        id = R.string.next
                    )
                )
            }
        }
    }

}