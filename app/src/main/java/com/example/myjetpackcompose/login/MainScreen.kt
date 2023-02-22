package com.example.myjetpackcompose.login

sealed class MainScreen ( val route: String){
    object SplashScreen:MainScreen("splash_screen")
    object LoginScreen: MainScreen("login_screen")
    object MahasiswaScreen: MainScreen("mahasiswa_screen")
    object DosenScreen: MainScreen("dosen_screen")

}
