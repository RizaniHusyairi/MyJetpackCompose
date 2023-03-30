package com.example.myjetpackcompose.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.JadwalTemp
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.ui.theme.ColorHasil
import com.example.myjetpackcompose.ui.theme.ColorPendadaran
import com.example.myjetpackcompose.ui.theme.ColorProposal

@Composable
fun CustomListJadwal(jadwal:JadwalTemp){
    val colorBox = when(jadwal.posisiSkripsi){
        "Proposal" -> ColorProposal
        "Hasil" -> ColorHasil
        "Pendadaran" -> ColorPendadaran
        else -> Color.Transparent
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorBox,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = jadwal.foto),
                    contentDescription =jadwal.nama,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column() {
                    Text(
                        text = jadwal.nama,
                        fontFamily = customFontPoppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                    Text(
                        text = jadwal.nim,
                        fontFamily = customFontPoppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )

                }

            }
            Box(
                modifier = Modifier
                    .background(
                        color = colorBox,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp) ) {
                Text(
                    text = jadwal.posisiSkripsi,
                    fontFamily = customFontPoppins,
                    fontSize = 13.sp,
                    color = Color.White
                )
            }
        }
        Text(text = jadwal.tanggalPelaksanaan.toString() + " | " + jadwal.waktuPelaksanaan)


    }

}