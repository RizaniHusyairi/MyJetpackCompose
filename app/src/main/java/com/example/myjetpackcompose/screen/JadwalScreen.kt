package com.example.myjetpackcompose.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.feature_skripsweet.data.repository.JadwalRepo
import com.example.myjetpackcompose.screen.component.CustomListJadwal
import com.example.myjetpackcompose.screen.component.CustomTopSkripsi


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun JadwalScreen() {
    Spacer(modifier = Modifier.padding(top = 100.dp))
    val jadwalRepo = JadwalRepo()
    val getAllData = jadwalRepo.getAllData()
    
    LazyColumn(
        modifier = Modifier.padding(top = 100.dp, end = 10.dp, start = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        content = {
        items(items = getAllData){jadwal ->
            CustomListJadwal(jadwal = jadwal)
        }
    })
}