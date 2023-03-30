package com.example.myjetpackcompose.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PunchClock
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.NontonSeminar
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.ui.theme.*


@Composable
fun CustomListNonton(nonton: NontonSeminar){
    val colorBox = when(nonton.status){
        "Reservasi" -> ColorReservasi
        "Disetujui" -> ColorDisetujui
        else -> Color.Transparent
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(
            color = colorBox,
            shape = RoundedCornerShape(
                topStart = 5.dp,
                topEnd = 5.dp,
                bottomStart = 2.dp,
                bottomEnd = 2.dp
            )
        )
        .padding(8.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Outlined.PunchClock,
                        contentDescription = "waktu pelaksanaan",
                        tint = Color.White,
                        modifier = Modifier
                            .size(15.dp)
                            .padding(end = 6.dp)
                    )
                    Text(
                        text = nonton.tanggalSeminar.toString(),
                        fontFamily = customFontPoppins,
                        fontSize = 10.sp,
                        color = Color.White

                    )

                }
                Text(
                    text = nonton.status,
                    fontFamily = customFontPoppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 10.sp,
                    color = Color.White
                )


            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 2.dp,
                    ),
                color = Color.Transparent,
                thickness = 0.dp
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "Seminar Ke - " + nonton.id,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = customFontPoppins,
                fontWeight = FontWeight.Medium,
                textDecoration = TextDecoration.Underline,
                fontSize = 11.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = nonton.judul,
                fontFamily = customFontPoppins,
                fontSize = 11.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Column() {
                    Text(
                        text = "Ketua/Pembimbing Seminar :",
                        fontFamily = customFontPoppins,
                        fontSize = 9.sp,
                        color = Color.White
                    )
                    Text(
                        text = nonton.ketuaSeminar,
                        fontFamily = customFontPoppins,
                        fontSize = 9.sp,
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(10.dp),
                        color = Color.White,
                    )
                    .padding(8.dp)
                ){

                    Text(
                        text = nonton.posisiSkripsi,
                        fontFamily = customFontPoppins,
                        fontSize = 10.sp,
                        color = Color.White

                    )
                }
            }
        }

    }

}