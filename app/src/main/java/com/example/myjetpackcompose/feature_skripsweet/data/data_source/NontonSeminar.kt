package com.example.myjetpackcompose.feature_skripsweet.data.data_source

import java.time.LocalDate

data class NontonSeminar (
    val id:Int,
    val judul: String,
    val ketuaSeminar: String,
    val tanggalSeminar: LocalDate,
    val posisiSkripsi: String,
    val status: String
        )