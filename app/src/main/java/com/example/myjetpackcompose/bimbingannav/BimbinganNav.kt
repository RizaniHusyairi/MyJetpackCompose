package com.example.myjetpackcompose.bimbingannav

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.BimbinganMahasiswaTemp
import com.example.myjetpackcompose.screen.BimbinganScreen

@Composable
fun BimbinganNav(dataBimbingan: List<BimbinganMahasiswaTemp>) {
    val navController = rememberNavController()

    Scaffold() {
        BimbinganNavGraph(navController, dataBimbingan = dataBimbingan)


    }
}

@Composable
fun BimbinganNavGraph(navController: NavHostController,dataBimbingan: List<BimbinganMahasiswaTemp>){

    NavHost(navController = navController, startDestination = "BimbinganLengkap" ){
        composable("BimbinganLengkap"){
            BimbinganScreen(navController = navController, dataBimbingan = dataBimbingan)
        }

    }


}