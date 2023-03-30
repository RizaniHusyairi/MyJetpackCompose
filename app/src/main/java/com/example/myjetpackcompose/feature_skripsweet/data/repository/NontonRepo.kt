package com.example.myjetpackcompose.feature_skripsweet.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.NontonSeminar
import java.time.LocalDate

class NontonRepo {
    @RequiresApi(Build.VERSION_CODES.O)
    fun GetAllData(): List<NontonSeminar>{
        return listOf(
            NontonSeminar(
                1,
                "PENERAPAN METODE TECHNOLOGY ACCEPTANCE MODEL (TAM) UNTUK MENGUKUR PENERIMAAN WEBSITE PEJABAT PENGELOLA INFORMASI DAN DOKUMENTASI (PPID) DI DISKOMINFO KOTA SAMARINDA",
                "Putut Pamilih Widagdo, S.kom., M. kom",
                LocalDate.of(2022,9,8),
                "Proposal",
                "Reservasi"
            ),
            NontonSeminar(
                2,
                "PENERAPAN METODE UTAUT UNTUK MENGUKUR PENERIMAAN WEBSITE PEJABAT PENGELOLA INFORMASI DAN DOKUMENTASI (PPID) DI DISKOMINFO KOTA SAMARINDA",
                "Putut Pamilih Widagdo, S.kom., M. kom",
                LocalDate.of(2022,6,20),
                "Proposal",
                "Disetujui"
            )
        )

    }
}