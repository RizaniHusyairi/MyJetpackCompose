package com.example.myjetpackcompose.feature_skripsweet.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.BimbinganMahasiswaTemp
import java.time.LocalDate

class BimbinganRepo {
    @RequiresApi(Build.VERSION_CODES.O)
    fun GetAllData():List<BimbinganMahasiswaTemp>{
        return listOf(
            BimbinganMahasiswaTemp(
                1,
                "Proposal",
                "revisi permasalahan latar belakang penelitian\n" + "menambah batasan masalah",
                LocalDate.of(2023,8,23),
                "Putut Pamilih Widagdo, S.kom., M. kom"


            ),
            BimbinganMahasiswaTemp(
                2,
                "Hasil",
                "revisi permasalahan latar belakang penelitian\n" + "menambah batasan masalah",
                LocalDate.of(2023,9,23),
                "Putut Pamilih Widagdo, S.kom., M. kom"


            ),
            BimbinganMahasiswaTemp(
                3,
                "Pendadaran",
                "revisi permasalahan latar belakang penelitian\n" + "menambah batasan masalah",
                LocalDate.of(2023,10,23),
                "Putut Pamilih Widagdo, S.kom., M. kom"


            ),

        )
    }
}