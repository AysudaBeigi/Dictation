package com.example.dictation.presentation.ui

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

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit,
) {
    TopAppBar(modifier = modifier) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = onNavigationIconClick,
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                )
            }
        }

    }
}