package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
    score: Int,
    onSubmitClicked: (String) -> Unit,
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
                onClick = { onSubmitClicked(inputValue.value.text) },
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
            onSubmitClicked = { /*TODO*/ },
            onReadWordClicked = { /*TODO*/ },
            onNextClicked = { /*TODO*/ })
    }
}