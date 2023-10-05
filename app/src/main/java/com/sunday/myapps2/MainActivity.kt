package com.sunday.myapps2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.sunday.myapps2.ui.theme.MyApps2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(navController)
                }
                // composable("detail?mediaId={mediaId}") { /*optional*/
                composable(
                    route = "detail/{mediaId}",             /*mandatory*/
                    arguments = listOf(
                        navArgument("mediaId") { type = NavType.IntType }
                    )
                ) { entry ->
                    val mediaId = entry.arguments?.getInt("mediaId")
                    requireNotNull(mediaId, {""}) // Pass from: Int?, to: Int
                    DetailScreen(mediaId)   // It could be: DetailScreen(mediaId!!)
                }
            }
        }
    }
}

