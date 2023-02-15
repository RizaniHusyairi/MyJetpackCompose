package com.example.myjetpackcompose.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myjetpackcompose.screen.HomeScreen
import com.example.myjetpackcompose.screen.ProfileScreen
import com.example.myjetpackcompose.screen.ReportScreen


@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route){
        composable(BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(BottomBarScreen.Report.route){
            ReportScreen()
        }
        composable(BottomBarScreen.Profile.route){
            ProfileScreen()
        }
    }
}