package com.example.myjetpackcompose.feature_skripsweet.data.data_source

import java.time.LocalDate

data class BimbinganMahasiswaTemp(
    val id: Int,
    val posisiSkripsi: String,
    val catatanBimbingan: String,
    val date: LocalDate,
    val dosenPembimbing: String
)