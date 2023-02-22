package com.example.myjetpackcompose.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.myjetpackcompose.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon : Int,
    val iconActive : Int
){
    object Skripsi: BottomBarScreen(
        route = "skripsweet",
        title = "Skripsweet",
        icon = R.drawable.skripsi_icon,
        iconActive = R.drawable.skripsi_active_ic
    )

    object Jadwal: BottomBarScreen(
        route = "jadwal",
        title = "Jadwal Seminar",
        icon = R.drawable.jadwal_icon,
        iconActive = R.drawable.jadwal_active_ic
    )

    object Nonton: BottomBarScreen(
        route = "nonton",
        title = "Nonton Seminar",
        icon = R.drawable.nonton_icon,
        iconActive = R.drawable.nonton_active_ic
    )
    object Judul: BottomBarScreen(
        route = "judul",
        title = "Judul Skripsi",
        icon = R.drawable.judul_icon,
        iconActive = R.drawable.judul_active_ic
    )
    object Setting: BottomBarScreen(
        route = "setting",
        title = "Setting",
        icon = R.drawable.setting_icon,
        iconActive = R.drawable.setting_active_ic
    )




}
