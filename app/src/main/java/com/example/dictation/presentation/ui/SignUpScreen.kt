package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import com.example.dictation.R

@Composable
fun SignUpScreen(modifier: Modifier,onSignUpClicked:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val inputValue = remember { mutableStateOf(TextFieldValue()) }
        Text(text = stringResource(id = R.string.first_name))
        OutlinedTextField(value = inputValue.value, onValueChange = { inputValue.value = it })
        Text(text = stringResource(id = R.string.last_name))
        OutlinedTextField(value = inputValue.value, onValueChange = { inputValue.value = it })
        Text(text = stringResource(id = R.string.phone_number))
        OutlinedTextField(value = inputValue.value, onValueChange = { inputValue.value = it })

        Button(onClick = { onSignUpClicked()}) {
            Text(text = stringResource(id = R.string.sign_up))
        }
    }
}