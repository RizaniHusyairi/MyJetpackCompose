package com.example.myjetpackcompose.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.myjetpackcompose.feature_skripsweet.data.repository.JadwalRepo
import com.example.myjetpackcompose.feature_skripsweet.data.repository.JudulRepo
import com.example.myjetpackcompose.screen.component.CustomListJadwal
import com.example.myjetpackcompose.screen.component.CustomListJudul
import com.example.myjetpackcompose.screen.component.CustomTopSkripsi
import com.example.myjetpackcompose.ui.theme.ColorPembimbingan


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun JudulScreen() {
    Spacer(modifier = Modifier.padding(bottom = 100.dp))
    val judulRepo = JudulRepo()
    val getAllData = judulRepo.GetAllData()

    LazyColumn(
        modifier = Modifier
            .padding(top = 100.dp, end = 10.dp, start = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            items(items = getAllData){judul ->
                CustomListJudul(judul = judul)
            }
        })
}