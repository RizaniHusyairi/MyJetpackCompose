package com.example.myjetpackcompose.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjetpackcompose.bottomnav.BottomNav

@Composable
fun LoginNav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainScreen.LoginScreen.route){
        composable(route = MainScreen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = MainScreen.MahasiswaScreen.route){
            BottomNav()
        }
    }
}