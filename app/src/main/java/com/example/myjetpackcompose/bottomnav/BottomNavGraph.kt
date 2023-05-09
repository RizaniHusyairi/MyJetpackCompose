package com.example.myjetpackcompose.bottomnav

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myjetpackcompose.bimbingannav.BimbinganNav
import com.example.myjetpackcompose.feature_skripsweet.data.repository.BimbinganRepo
import com.example.myjetpackcompose.screen.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingvalue: PaddingValues
) {
    val bimbinganRepo = BimbinganRepo()
    val getAllData = bimbinganRepo.GetAllData()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Skripsi.route,
    modifier = Modifier.padding(paddingvalue)){
        composable(BottomBarScreen.Skripsi.route){
            HomeScreen(navController,getAllData)
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
        composable("Bimbingan"){
            BimbinganNav(getAllData)
        }
    }
}