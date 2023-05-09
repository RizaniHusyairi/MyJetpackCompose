package com.example.myjetpackcompose.screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.BimbinganMahasiswaTemp
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.ui.theme.ColorHasil
import com.example.myjetpackcompose.ui.theme.ColorPendadaran
import com.example.myjetpackcompose.ui.theme.ColorProposal


@Composable
fun CustomListBimbinganHome(bimbingan: BimbinganMahasiswaTemp){

    val colorBorder = when(bimbingan.posisiSkripsi){
        "Proposal" -> ColorProposal
        "Hasil" -> ColorHasil
        "Pendadaran" -> ColorPendadaran
        else -> Color.Transparent
    }

    Card(
        modifier = Modifier.size(width = 300.dp, height = 150.dp),
        border = BorderStroke(width = 1.dp, color = colorBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "Bimbingan Ke - ${bimbingan.id}",
                        fontFamily = customFontPoppins,
                        fontWeight = FontWeight.Medium
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(color = colorBorder, shape = RoundedCornerShape(8.dp))
                            .padding(3.dp)
                    ) {
                        Text(
                            text = bimbingan.posisiSkripsi,
                            fontFamily = customFontPoppins,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
                Text(text = bimbingan.catatanBimbingan)

            }

            Column() {
                Divider(modifier = Modifier.border(width = 1.dp, color = Color.Gray))
                Text(text = bimbingan.date.toString())

            }

        }



    }
}

@Composable
fun CustomBimbinganLengkap(bimbingan: BimbinganMahasiswaTemp){


}