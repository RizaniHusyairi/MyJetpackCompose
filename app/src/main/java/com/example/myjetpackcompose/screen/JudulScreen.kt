package com.example.myjetpackcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun JudulScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Judul", fontSize = 20.sp)

    }
}