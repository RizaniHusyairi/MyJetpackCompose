package com.example.myjetpackcompose.login

sealed class MainScreen ( val route: String){
    object LoginScreen: MainScreen("login_screen")
    object MahasiswaScreen: MainScreen("mahasiswa_screen")
}
