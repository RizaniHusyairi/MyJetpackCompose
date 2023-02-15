package com.example.myjetpackcompose.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon : ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Rounded.Home
    )

    object Report: BottomBarScreen(
        route = "report",
        title = "Report",
        icon = Icons.Rounded.Warning
    )

    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Rounded.Person
    )
}
