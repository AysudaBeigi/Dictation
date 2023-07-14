package com.example.dictation.presentation.ui

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.trimmedLength
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.Failed
import com.example.dictation.base.LoadableData
import com.example.dictation.base.Loaded
import com.example.dictation.base.Loading
import com.example.dictation.base.NotLoaded
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.FailedComponent
import com.example.dictation.core.LoadingComponent
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
            LoadingComponent()
        }

        is Loaded -> {
            LoadedProfileScreenContent(modifier, user, onRegisterClicked)
        }

        is Failed -> {
            FailedComponent()
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
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .fillMaxWidth()
                .height(48.dp),
            onClick = {
                onRegisterClicked(
                    firstName.value,
                    lastName.value,
                    phoneNumber.value
                )
            },
            title = stringResource(id = R.string.save),
            enabled = inputsAreNotEmpty(firstName, lastName, phoneNumber)
        )
    }
}

private fun inputsAreNotEmpty(
    firstName: MutableState<String>,
    lastName: MutableState<String>,
    phoneNumber: MutableState<String>
) = firstName.value.isNotBlank() && lastName.value.isNotBlank() && phoneNumber.value.isNotBlank()

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun UserInformationTextFields(
    modifier: Modifier,
    firstName: MutableState<String>,
    lastName: MutableState<String>,
    phoneNumber: MutableState<String>
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = dictationTheme.colors.background)
            .padding(16.dp)
    ) {
        Space(size = 64.dp)
        UserInformationItemTextFiled(
            value = firstName.value,
            onValueChange = { firstName.value = it },
            keyboardType = KeyboardType.Text,
            labelSrc = R.string.first_name,
            placeholderSrc = R.string.enter_first_name,
            keyboardActions = KeyboardActions(onNext = {

            })
        )
        Space(size = 32.dp)
        UserInformationItemTextFiled(
            value = lastName.value,
            onValueChange = { lastName.value = it },
            keyboardType = KeyboardType.Text,
            labelSrc = R.string.last_name,
            placeholderSrc = R.string.enter_last_name,
        )
        Space(size = 32.dp)
        UserInformationItemTextFiled(
            value = phoneNumber.value,
            onValueChange = {
                phoneNumber.value = it
            },
            keyboardType = KeyboardType.Phone,
            labelSrc = R.string.phone_number,
            placeholderSrc = R.string.enter_phone_number,
        )
        Space(size = 32.dp)

    }
}

@Composable
private fun UserInformationItemTextFiled(
    modifier: Modifier = Modifier,
    value: String,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    labelSrc: Int,
    placeholderSrc: Int,
    isError: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth(),
        shape = dictationTheme.shapes.medium,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = dictationTheme.colors.pink,
            textColor = dictationTheme.colors.primary,
            errorBorderColor = dictationTheme.colors.darkRed,
            errorLabelColor = dictationTheme.colors.darkRed,
            unfocusedBorderColor = dictationTheme.colors.primary,
            placeholderColor = dictationTheme.colors.pink,
            focusedLabelColor = dictationTheme.colors.pink,
            unfocusedLabelColor = dictationTheme.colors.pink,
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isError,
        placeholder = @Composable {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = placeholderSrc),
                    style = dictationTheme.typography.h4,
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Start,
                    color = dictationTheme.colors.pink
                )
            }

        },
        label = @Composable {
            Text(
                text = stringResource(id = labelSrc),
                style = dictationTheme.typography.h4,
                modifier = Modifier,
                textAlign = TextAlign.Start,
                color = dictationTheme.colors.primary,
            )
        },
        keyboardActions = keyboardActions,
    )
}

fun isValidPhone(phone: String): Boolean =
    phone.trimmedLength() in (10..13) && Patterns.PHONE.matcher(phone).matches()

@Composable
@Preview
fun ProfileScreenPreview() {
    DictationTheme {
        ProfileScreen(
            user = Loaded(
                User(
                    firstName = "aysuda",
                    lastName = "beigi",
                    phoneNumber = "98912345678",
                    score = 20
                )
            ),
            onRegisterClicked = { _, _, _ -> })
    }
}