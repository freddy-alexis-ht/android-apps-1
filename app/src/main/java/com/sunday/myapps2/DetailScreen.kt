package com.sunday.myapps2

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.sunday.myapps2.common.Thumb


@Composable
fun DetailScreen(mediaId: Int) {
    val mediaItem = remember {getMedia().first {it.id == mediaId}}

    Scaffold(
        topBar = { TopAppBar( title = { Text(text = mediaItem.title) }) }
    ) {
        Thumb(item = mediaItem)
    }
}
