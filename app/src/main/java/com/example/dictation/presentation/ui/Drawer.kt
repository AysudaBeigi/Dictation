package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.base.DictationTheme
import com.example.dictation.base.dictationTheme
import com.example.dictation.core.Space

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onProfileClicked: () -> Unit,
    onScoreClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .background(color = dictationTheme.colors.background)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Space(size = 32.dp)
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_profile,
            text = stringResource(id = R.string.profile),
            onItemClick = onProfileClicked
        )
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = dictationTheme.colors.gray)
        )
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_setting,
            text = stringResource(id = R.string.score),
            onItemClick = onScoreClicked
        )
    }
}

@Composable
private fun DrawerMenuItem(
    iconDrawableId: Int,
    text: String,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(iconDrawableId),
            contentDescription = null,
            tint = dictationTheme.colors.gray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            style = dictationTheme.typography.h2,
            color = dictationTheme.colors.primary
        )
    }
}

@Composable
@Preview
fun DrawerPreview() {
    DictationTheme {
        Drawer(onProfileClicked = {}, onScoreClicked = {})
    }
}