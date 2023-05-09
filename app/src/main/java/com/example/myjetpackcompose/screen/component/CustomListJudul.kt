package com.example.myjetpackcompose.screen.component

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.JudulSkripsi
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.ui.theme.*


@Composable
fun CustomListJudul(judul: JudulSkripsi) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val colorBox = when(judul.status){
        "Pembimbingan" -> ColorPembimbingan
        "Penjadwalan" -> ColorPenjadwalan
        "Seminar" -> ColorSeminar
        "Lulus" -> ColorLulus
        else -> Color.Transparent
    }

    val colorButton = when(judul.status){
        "Pembimbingan" -> ColorButtonPembimbingan
        "Penjadwalan" -> ColorButtonPenjadwalan
        "Seminar" -> ColorButtonSeminar
        "Lulus" -> ColorButtonLulus
        else -> Color.Transparent
    }

    Column() {
        var isVisible by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorBox,
                    shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)

                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = judul.status,
                fontFamily = customFontPoppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 10.sp,
                color = Color.White

            )
            Text(
                text = judul.posisiSripsi,
                fontFamily = customFontPoppins,
                fontSize = 10.sp,
                color = Color.White

            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorBox
                )
                .shadow(
                    elevation = 6.dp
                ),
            thickness = 0.dp,
            color = Color.Transparent
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorBox,
                    shape = RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp)
                )
                .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = "Judul Skripsi",
                fontFamily = customFontPoppins,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                text = judul.judul,
                textAlign = TextAlign.Center,
                fontFamily = customFontPoppins,
                color = Color.White,
                fontSize = 10.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,

                    ),
                    contentPadding = PaddingValues(),
                    onClick = {
                        isVisible = !isVisible

                    },
                    modifier = Modifier.padding(0.dp)
                ){
                    Box(
                        modifier = Modifier
                            .background(
                                color = colorButton,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(8.dp),
                                color = colorBox
                            )
                            .padding(5.dp)
    //                        .clickable(onClick = {
    //                            isVisible = !isVisible
    //                        })
                    ) {
                        Text(
                            text = "Lihat Dosen Penilai",
                            fontFamily = customFontPoppins,
                            fontSize = 10.sp,
                            color = Color.White
                        )

                    }
                }

            }
        }
        AnimatedVisibility(
            visible = isVisible,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier

                    .offset(y = (-2).dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = colorBox,
                        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                    )
                    .padding(8.dp)
            ) {
                BoxDosenPenilai(
                    nama = judul.dospem1,
                    status = "Belum Menilai",
                    statusDosen = "Pembimbing 1",
                    foto = R.drawable.bapak_putut
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.Black
                        )

                )
                BoxDosenPenilai(
                    nama = judul.dospem2,
                    status = "Selesai",
                    statusDosen = "Pembimbing 2",
                    foto = R.drawable.bapak_putut
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.Black
                        )

                )
                BoxDosenPenilai(
                    nama = judul.dospem2,
                    status = "Belum Revisian",
                    statusDosen = "Penguji 1",
                    foto = R.drawable.bapak_putut
                )


            }
        }

    }
}
@Composable
fun showToast(message: String) {
    val context = LocalContext.current
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun BoxDosenPenilai(
    nama: String,
    status: String,
    statusDosen: String,
    foto: Int


){
    val colorDosen = when(statusDosen){
        "Pembimbing 1" -> ColorPembimbing
        "Pembimbing 2" -> ColorPembimbing
        "Penguji 1" -> ColorPenguji
        "Penguji 2" -> ColorPenguji
        else -> {Color.Transparent}
    }
    val colorStatus = when(status){
        "Belum Revisian" -> ColorBelumRevisian
        "Belum Menilai" -> ColorBelumMenilai
        "Selesai" -> ColorSelesai
        else -> {Color.Transparent}
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row() {
            Image(
                painter = painterResource(id = foto),
                contentDescription = nama,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.padding(start = 5.dp)
            ){
                Text(
                    text = nama,
                    fontFamily = customFontPoppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 11.sp,

                    )
                Text(
                    text = "3494723472",
                    fontFamily = customFontPoppins,
                    fontSize = 10.sp
                )

            }

        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = colorDosen,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(4.dp)
            ) {
                Text(
                    text = statusDosen,
                    fontFamily = customFontPoppins,
                    fontSize = 9.sp,
                    color = Color.White
                )

            }
            Spacer(modifier = Modifier.padding(3.dp))
            Box(modifier = Modifier
                .background(
                    color = colorStatus,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(4.dp)
            ) {
                Text(
                    text = status,
                    fontFamily = customFontPoppins,
                    fontSize = 9.sp,
                    color = Color.White
                )

            }

        }

    }

}