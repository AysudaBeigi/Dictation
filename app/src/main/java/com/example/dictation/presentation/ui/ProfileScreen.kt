package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.Failed
import com.example.dictation.base.LoadableData
import com.example.dictation.base.Loaded
import com.example.dictation.base.Loading
import com.example.dictation.base.NotLoaded
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.PrimaryButton
import com.example.dictation.core.Space
import com.example.dictation.domain.User

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    user: LoadableData<User?>,
    onRegisterClicked: (String, String, String) -> Unit,
) {

    when (user) {
        is Loading, NotLoaded -> {

            Text(text = "loading ", style = dictationTheme.typography.h1, color = Color.Black)
        }

        is Loaded -> {
            LoadedProfileScreenContent(modifier, user, onRegisterClicked)
        }

        is Failed -> {
            Text(text = "failed", style = dictationTheme.typography.h1, color = Color.Black)
        }

    }
}

@Composable
private fun LoadedProfileScreenContent(
    modifier: Modifier,
    user: LoadableData<User?>,
    onRegisterClicked: (String, String, String) -> Unit
) {
    val firstName = remember {
        mutableStateOf(user.data?.firstName ?: "")
    }
    val lastName = remember {
        mutableStateOf(user.data?.lastName ?: "")
    }
    val phoneNumber = remember {
        mutableStateOf(user.data?.phoneNumber ?: "")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        UserInformationTextFields(
            modifier.align(Alignment.TopCenter),
            firstName, lastName, phoneNumber
        )
        PrimaryButton(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(32.dp)
                .fillMaxWidth(),
            onClick = {
                onRegisterClicked(
                    firstName.value,
                    lastName.value,
                    phoneNumber.value
                )
            },
            title = stringResource(id = R.string.save)
        )
    }
}


@Composable
private fun UserInformationTextFields(
    modifier: Modifier,
    firstName: MutableState<String>,
    lastName: MutableState<String>,
    phoneNumber: MutableState<String>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = dictationTheme.colors.background)
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(id = R.string.first_name))
        Space(size = 8.dp)
        UserInformationItemTextFiled(
            value = firstName.value,
            onValueChange = { firstName.value = it },
        )

        Spacer(modifier = Modifier.size(32.dp))

        Text(text = stringResource(id = R.string.last_name))
        UserInformationItemTextFiled(
            value = lastName.value,
            onValueChange = { lastName.value = it })

        Spacer(modifier = Modifier.size(32.dp))

        Text(text = stringResource(id = R.string.phone_number))
        UserInformationItemTextFiled(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it })
        Spacer(modifier = Modifier.size(32.dp))

    }
}

@Composable
private fun UserInformationItemTextFiled(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = label,
        shape = dictationTheme.shapes.medium,
        colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor = dictationTheme.colors.pink)
    )
}

@Composable
@Preview
fun ProfileScreenPreview() {
    DictationTheme {
        ProfileScreen(
            user = Loaded(User(firstName = "", lastName = "", phoneNumber = "", score = 20)),
            onRegisterClicked = { _, _, _ -> })
    }
}