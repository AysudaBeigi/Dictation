package com.example.dictation.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.dictation.base.dictationTheme

@Composable
fun Space(modifier: Modifier = Modifier, size: Dp) = Spacer(modifier = modifier.size(size))

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title:String
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = dictationTheme.colors.pink,
        ), shape = dictationTheme.shapes.medium
    ) {
        Text(
            text = title,
            color = dictationTheme.colors.primary,
            modifier = Modifier,
            style = dictationTheme.typography.h2
        )
    }
}
