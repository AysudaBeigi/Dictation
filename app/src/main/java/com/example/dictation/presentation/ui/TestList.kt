package com.example.dictation.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dictation.base.PaginationLoadableData
import com.example.dictation.base.dictationTheme
import com.example.dictation.base.isLoaded
import com.example.dictation.base.isLoading
import com.example.dictation.base.isNotLoaded

fun LazyListState.isScrolledToEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1

@Composable
fun TestList(
    modifier: Modifier = Modifier,
    paginated: PaginationLoadableData<List<Char>>,
    onLoadMore:()->Unit,
) {

    Box(modifier = modifier.fillMaxSize().background(color = dictationTheme.colors.background), contentAlignment = Alignment.Center) {

        val state = rememberLazyListState()
        val shouldLoadMore = state.isScrolledToEnd()

        LaunchedEffect(key1 = shouldLoadMore) {
            if (shouldLoadMore) {
                onLoadMore()
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(), state = state
        ) {

            val data = paginated.data?: emptyList()
            when {
                paginated.isLoaded() -> {
                    if (data.isEmpty()) {
                        item {
                           Text(text = "This is empty view ",style = dictationTheme.typography.h2)
                        }
                    } else {
                        items(data){
                            Text(text = it.toString(), style = dictationTheme.typography.h1)

                        }
                    }
                }
                paginated.isLoading() -> {
                    item {
                        LoadingItem(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillParentMaxSize()
                        )
                    }
                }
                paginated.isNotLoaded() ->{
                    item {
                        Text(text = "Not Loaded  ......", style = dictationTheme.typography.h2, textAlign = TextAlign.Center)

                    }
                }
            }
        }
    }
}

@Composable
private fun LoadingItem(modifier: Modifier = Modifier) {
    Text(text = "Loading ......", style = dictationTheme.typography.h2, textAlign = TextAlign.Center)
}