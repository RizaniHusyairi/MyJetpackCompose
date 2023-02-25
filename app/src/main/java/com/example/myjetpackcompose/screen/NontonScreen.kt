package com.example.myjetpackcompose.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.screen.component.CustomTopSkripsi


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NontonScreen() {
//    Scaffold(
//        topBar ={ CustomTopSkripsi("Nonton Seminar") }
//    ) {
//
//    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Nonton", fontSize = 20.sp)

    }
}