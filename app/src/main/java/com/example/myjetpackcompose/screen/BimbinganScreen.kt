package com.example.myjetpackcompose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.BimbinganMahasiswaTemp
import com.example.myjetpackcompose.font.customFontPoetsen
import com.example.myjetpackcompose.ui.theme.ColorIconBar

@Composable
fun BimbinganScreen(navController: NavHostController, dataBimbingan: List<BimbinganMahasiswaTemp>){
Scaffold(
    topBar = {
        TopBarBimbingan(onBackPressed = {navController.popBackStack()})
    }
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(7.dp),

        content = {
        items(items = dataBimbingan){bimbingan ->
            Text(text = bimbingan.posisiSkripsi)

        }
    })

}

}

@Composable
fun TopBarBimbingan(onBackPressed: () -> Unit = {}){
    TopAppBar(
        title = { Text(
            text = "Kegiatan Bimbingan Skripsi",
            fontFamily = customFontPoetsen,
            color = ColorIconBar
        )},
    navigationIcon = {
        IconButton(onClick = { onBackPressed() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back")
            
        }     
    })

}