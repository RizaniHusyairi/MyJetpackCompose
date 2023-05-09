package com.example.myjetpackcompose.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myjetpackcompose.feature_skripsweet.data.repository.JudulRepo
import com.example.myjetpackcompose.screen.component.CustomListJudul


@Composable
fun JudulScreen() {
    val judulRepo = JudulRepo()
    val getAllData = judulRepo.GetAllData()

    LazyColumn(
        modifier = Modifier
            .height(766.dp)
            .padding(end = 10.dp, start = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            items(items = getAllData){judul ->
                CustomListJudul(judul = judul)
            }
        })
}