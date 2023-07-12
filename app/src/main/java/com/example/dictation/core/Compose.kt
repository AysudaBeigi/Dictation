package com.example.dictation.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.dictationTheme

@Composable
fun Space(modifier: Modifier = Modifier, size: Dp) = Spacer(modifier = modifier.size(size))

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = dictationTheme.colors.pink,
            disabledBackgroundColor = dictationTheme.colors.disable,
        ), shape = dictationTheme.shapes.medium, enabled = enabled
    ) {
        Text(
            text = title,
            color = dictationTheme.colors.primary,
            modifier = Modifier,
            style = dictationTheme.typography.h2
        )
    }
}

@Composable
fun LoadingComponent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = dictationTheme.colors.pink
        )
    }
}

@Composable
fun FailedComponent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Icon(
                painter = painterResource(id = R.drawable.error_24),
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                tint = dictationTheme.colors.lightRed
            )
            Space(size = 64.dp)
            Text(
                text = stringResource(id = R.string.error),
                style = dictationTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )
        }

    }
}
