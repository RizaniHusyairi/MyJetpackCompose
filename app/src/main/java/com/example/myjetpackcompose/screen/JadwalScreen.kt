package com.example.myjetpackcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun JadwalScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Jadwal", fontSize = 20.sp)

    }
}