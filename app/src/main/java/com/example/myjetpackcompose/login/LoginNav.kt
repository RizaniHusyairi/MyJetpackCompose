package com.example.myjetpackcompose.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjetpackcompose.bottomnav.BottomNav

@Composable
fun LoginNav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainScreen.SplashScreen.route){
        composable(route = MainScreen.SplashScreen.route){
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = MainScreen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = MainScreen.MahasiswaScreen.route){
            BottomNav()
        }
        composable(route = MainScreen.DosenScreen.route){

        }
    }
}