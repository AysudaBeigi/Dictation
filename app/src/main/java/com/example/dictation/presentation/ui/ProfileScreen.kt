package com.example.dictation.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.*
import com.example.dictation.core.Space
import com.example.dictation.domain.User

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    user: LoadableData<User?>,
    onRegisterClicked: (String, String, String) -> Unit,
) {

    when(user){
        is Loading ,NotLoaded->{

            Text(text = "loading ",  style = dictationTheme.typography.h1, color= Color.Black)
        }
        is Loaded->{
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp), verticalArrangement = Arrangement.Center
            ) {
                val firstName = remember {
                    mutableStateOf(user.data?.firstName?:"")
                }
                val lastName = remember {
                    mutableStateOf(user.data?.lastName?:"")
                }
                val phoneNumber = remember {
                    mutableStateOf(user.data?.phoneNumber?:"")
                }
                Text(text = stringResource(id = R.string.first_name))
                Space(size = 8.dp)
                TextField(
                    value = firstName.value,
                    onValueChange = { firstName.value = it },
                )

                Spacer(modifier = Modifier.size(32.dp))

                Text(text = stringResource(id = R.string.last_name))
                TextField(value = lastName.value, onValueChange = { lastName.value = it })

                Spacer(modifier = Modifier.size(32.dp))

                Text(text = stringResource(id = R.string.phone_number))
                TextField(value = phoneNumber.value, onValueChange = { phoneNumber.value = it })
                Spacer(modifier = Modifier.size(32.dp))
                Button(onClick = {
                    onRegisterClicked(
                        firstName.value,
                        lastName.value,
                        phoneNumber.value
                    )
                }) {
                    Text(text = stringResource(id = R.string.save))
                }
            }
        }
        is Failed->{
            Text(text = "failed" ,style = dictationTheme.typography.h1, color= Color.Black)
        }

    }


}