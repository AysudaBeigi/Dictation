package com.example.dictation.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dictation.R

@Composable
fun WordScreen(
    onSubmitClicked: () -> Unit,
    onReadWordClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val text= remember {
            mutableStateOf("")
        }
        Image(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = stringResource(id = R.string.read_word),
            modifier = modifier.clickable {onReadWordClicked() })

        TextField(value =text , onValueChange ={},modifier=Modifier, enabled = true , label = "",)
        Button(onClick = onSubmitClicked) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }

}