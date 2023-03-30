package com.example.myjetpackcompose.feature_skripsweet.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.JadwalTemp
import java.time.LocalDate
import java.time.LocalTime

class JadwalRepo {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllData():List<JadwalTemp>{
        return listOf(
            JadwalTemp(
                "Rizani Husyairi",
                "1915036123",
                R.drawable.contohpp1,
                "Proposal",
                LocalTime.of(13,30,0),
                LocalDate.of(2023,5,23)
            ),JadwalTemp(
                "Rizani Husyairi",
                "1915036124",
                R.drawable.contohpp1,
                "Hasil",
                LocalTime.of(13,30,0),
                LocalDate.of(2023,5,23)
            ),JadwalTemp(
                "Rizani Husyairi",
                "1915036125",
                R.drawable.contohpp1,
                "Pendadaran",
                LocalTime.of(13,30,0),
                LocalDate.of(2023,5,23)
            ),
        )
    }
}