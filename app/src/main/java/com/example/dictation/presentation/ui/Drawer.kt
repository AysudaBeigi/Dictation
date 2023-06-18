package com.example.dictation.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dictation.R
import com.example.dictation.core.Space

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
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }
}

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onProfileClicked: () -> Unit,
    onScoreClicked: () -> Unit
) {
    Column(modifier = modifier) {
        Space(size = 32.dp)
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_profile,
            text = stringResource(id = R.string.first_name),
            onItemClick = onProfileClicked
        )
        DrawerMenuItem(
            iconDrawableId = R.drawable.ic_setting,
            text = "Score",
            onItemClick = onScoreClicked
        )
    }
}