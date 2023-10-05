package com.sunday.myapps2.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import com.sunday.myapps2.MediaItem
import com.sunday.myapps2.R

@Composable
fun Thumb(item: MediaItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.cel_thumb_height))

    ) {
        AsyncImage(
            model = item.thumb,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (item.type == MediaItem.Type.VIDEO) {
            Icon(
                imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.cell_play_icon_size))
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
    }
}