package com.example.myjetpackcompose.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myjetpackcompose.screen.*


@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Skripsi.route){
        composable(BottomBarScreen.Skripsi.route){
            HomeScreen()
        }
        composable(BottomBarScreen.Jadwal.route){
            JadwalScreen()
        }
        composable(BottomBarScreen.Nonton.route){
            NontonScreen()
        }
        composable(BottomBarScreen.Judul.route){
            JudulScreen()
        }
        composable(BottomBarScreen.Setting.route){
            SettingScreen()
        }
    }
}