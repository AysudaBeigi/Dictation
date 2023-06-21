package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = dictationTheme.colors.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = dictationTheme.colors.background)
        ) {
            IconButton(
                onClick = onNavigationIconClick,
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = dictationTheme.colors.pink
                )
            }
        }

    }
}

@Composable
@Preview
fun TopBarPreview() {
    DictationTheme {
        TopBar() {

        }
    }
}