package com.sunday.myapps2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.sunday.myapps2.common.Thumb

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }) }
    ) { padding ->
        MediaList(navController = navController, modifier = Modifier.padding(padding))
    }
}

@Composable
fun MediaList(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaListItem(navController = navController, item = item)
        }
    }
}

@Composable
fun MediaListItem(navController: NavHostController, item: MediaItem) {
    Card(
        modifier = Modifier.clickable { navController.navigate("detail/${item.id}") },
        elevation = 0.dp,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        backgroundColor = MaterialTheme.colors.primary

    ) {
        Column {
            Thumb(item)
            Title(item)
        }
    }
}

@Composable
fun Title(item: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.secondary)
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.h6
        )
    }
}
