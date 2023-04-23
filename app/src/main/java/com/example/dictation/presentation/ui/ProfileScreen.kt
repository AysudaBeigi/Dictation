package com.example.dictation.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.domain.User

@Composable
fun ProfileScreen(modifier: Modifier, user: User) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = stringResource(id = R.string.first_name))
        TextField(value = user.firstName, onValueChange = { }, enabled = false)
        Spacer(modifier = Modifier.size(32.dp))
        Text(text = stringResource(id = R.string.last_name))
        TextField(value = user.lastName, onValueChange = {})
        Spacer(modifier = Modifier.size(32.dp))
        Text(text = stringResource(id = R.string.phone_number))
        TextField(value = user.phoneNumber, onValueChange = { })

    }

}