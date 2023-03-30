package com.example.myjetpackcompose.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.JudulSkripsi
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.ui.theme.*
import kotlinx.coroutines.launch

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
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                    ),
                    contentPadding = PaddingValues(),
                    onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("penilaian dosen")
                        }
                    }
                ){
                    Text(
                        text = "Lihat Dosen Penilai",
                        fontFamily = customFontPoppins,
                        fontSize = 9.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}