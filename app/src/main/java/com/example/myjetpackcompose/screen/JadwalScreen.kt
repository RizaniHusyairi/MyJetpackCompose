package com.example.myjetpackcompose.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myjetpackcompose.feature_skripsweet.data.repository.JadwalRepo
import com.example.myjetpackcompose.screen.component.CustomListJadwal


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JadwalScreen() {
    val jadwalRepo = JadwalRepo()
    val getAllData = jadwalRepo.getAllData()
    
    LazyColumn(
        modifier = Modifier.padding(end = 10.dp, start = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        content = {
        items(items = getAllData){jadwal ->
            CustomListJadwal(jadwal = jadwal)
        }
    })
}