package com.example.myjetpackcompose.feature_skripsweet.data.data_source

data class JudulSkripsi(
    val judul : String,
    val posisiSripsi: String,
    val status: String,
    val dospem1: String,
    val dospem2: String,


        )

data class Dosen(
    val nama : String,
    val nip : Int,
    val jurusan: String,
)
