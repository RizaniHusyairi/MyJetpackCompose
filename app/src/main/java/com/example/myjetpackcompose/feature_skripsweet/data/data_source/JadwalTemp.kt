package com.example.myjetpackcompose.feature_skripsweet.data.data_source

import androidx.annotation.DrawableRes
import java.time.LocalDate
import java.time.LocalTime

data class JadwalTemp(
    val nama:String,
    val nim:String,
    @DrawableRes val foto:Int,
    val posisiSkripsi: String,
    val waktuPelaksanaan:LocalTime,
    val tanggalPelaksanaan:LocalDate
)
